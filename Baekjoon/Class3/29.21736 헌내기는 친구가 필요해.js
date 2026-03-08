const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const MOVE_DIR = [[-1, 0], [1, 0], [0, -1], [0, 1]];

const [n, m] = input[0].split(" ").map(Number);

let bfsHead = 0;
const bfs = [];
const campus = [];
for(let r = 0; r < n; r++) {
    const row = input[r + 1];
    campus[r] = row.split("");
    const c = row.indexOf("I"); // 시작점 찾기
    if(c !== -1) {
        bfs.push([r, c]);
        campus[r][c] = "X"; // 방문 처리
    }
}

let people = 0; // 주변 사람 찾기
while(bfsHead < bfs.length) {
    const [startR, startC] = bfs[bfsHead++];
    for(const [moveR, moveC] of MOVE_DIR) { // 모든 방향에 대해
        const endR = startR + moveR;
        const endC = startC + moveC;
        if(endR < 0 || endR >= n || endC < 0 || endC >= m) // 경계 확인
            continue;
        const target = campus[endR][endC];
        if(target === "X")
            continue;
        if(target === "P") // 사람 발견
            people++;
        bfs.push([endR, endC]); // 빈 공간으로 이동
        campus[endR][endC] = "X" // 방문 처리
    }
}

if(people === 0) console.log("TT");
else console.log(people);