const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const MOVE_DIR = [[-1, 0], [1, 0], [0, -1], [0, 1]];

const [n, m] = input[0].split(" ").map(Number);

let bfsHead = 0;
const bfs = [];
const campus = [];
for(let x = 0; x < n; x++) {
    const row = input[x + 1];
    campus[x] = row.split("");
    const y = row.indexOf("I"); // 시작점 찾기
    if(y !== -1) {
        bfs.push([x, y]);
        campus[x][y] = "X"; // 방문 처리
    }
}

let people = 0; // 주변 사람 찾기
while(bfsHead < bfs.length) {
    const [startX, startY] = bfs[bfsHead++];
    for(const [moveX, moveY] of MOVE_DIR) { // 모든 방향에 대해
        const endX = startX + moveX;
        const endY = startY + moveY;
        if(endX < 0 || endX >= n || endY < 0 || endY >= m) // 경계 확인
            continue;
        const target = campus[endX][endY];
        if(target === "X")
            continue;
        if(target === "P") // 사람 발견
            people++;
        bfs.push([endX, endY]); // 빈 공간으로 이동
        campus[endX][endY] = "X" // 방문 처리
    }
}

if(people === 0) console.log("TT");
else console.log(people);