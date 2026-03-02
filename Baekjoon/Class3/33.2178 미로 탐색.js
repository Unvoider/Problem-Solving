const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const MOVE_DIR = [[-1, 0], [1, 0], [0, -1], [0, 1]];

const [n, m] = input[0].split(" ").map(Number);

const depths = Array.from({ length: n }, () => new Array(m).fill(0))
for(let x = 0; x < n; x++) { // 벽 0
    const row = input[x + 1];
    for(let y = 0; y < m; y++)
        if(row[y] === "1")
            depths[x][y] = -1; // 길 -1
}

let bfsHead = 0; // 너비 우선 탐색
const bfs = [[0, 0]]; // 출발 위치 [0, 0]
depths[0][0] = 1; // 출발 깊이 1
while(true) {
    const [startX, startY] = bfs[bfsHead++];
    if(startX === n - 1 && startY === m - 1) // 도착 위치 [n - 1, m - 1]
        break;
    for(const [moveX, moveY] of MOVE_DIR) {
        const endX = startX + moveX;
        const endY = startY + moveY;
        if(endX < 0 || endX >= n || endY < 0 || endY >= m) // 경계 확인
            continue;
        if(depths[endX][endY] == -1) { // 이동
            bfs.push([endX, endY]);
            depths[endX][endY] = depths[startX][startY] + 1;
        }
    }
}

console.log(depths[n - 1][m - 1]); // 도착 깊이