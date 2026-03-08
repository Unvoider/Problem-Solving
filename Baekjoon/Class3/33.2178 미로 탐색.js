const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const MOVE_DIR = [[-1, 0], [1, 0], [0, -1], [0, 1]];

const [n, m] = input[0].split(" ").map(Number);

const depths = Array.from({ length: n }, () => new Array(m).fill(0))
for(let r = 0; r < n; r++) { // 벽 0
    const row = input[r + 1];
    for(let c = 0; c < m; c++)
        if(row[c] === "1")
            depths[r][c] = -1; // 길 -1
}

let bfsHead = 0; // 너비 우선 탐색
const bfs = [[0, 0]]; // 출발 위치 [0, 0]
depths[0][0] = 1; // 출발 깊이 1
while(true) {
    const [startR, startC] = bfs[bfsHead++];
    if(startR === n - 1 && startC === m - 1) // 도착 위치 [n - 1, m - 1]
        break;
    for(const [moveR, moveC] of MOVE_DIR) {
        const endR = startR + moveR;
        const endC = startC + moveC;
        if(endR < 0 || endR >= n || endC < 0 || endC >= m) // 경계 확인
            continue;
        if(depths[endR][endC] == -1) { // 이동
            bfs.push([endR, endC]);
            depths[endR][endC] = depths[startR][startC] + 1;
        }
    }
}

console.log(depths[n - 1][m - 1]); // 도착 깊이