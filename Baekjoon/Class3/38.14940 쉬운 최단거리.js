const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const MOVE_DIR = [[-1, 0], [1, 0], [0, -1], [0, 1]];

const [n, m] = input[0].split(" ").map(Number);

const graph = []; // 격자 그래프
for(let i = 1; i <= n; i++)
    graph.push(input[i].split(" ").map(Number));

const depths = Array.from({ length : n }, () => new Array(m).fill(0));
let bfsHead = 0;
const bfs = [];
for(let r = 0; r < n; r++)
    for(let c = 0; c < m; c++) {
        const num = graph[r][c]
        if(num === 1)
            depths[r][c] = -1;
        else if(num === 2) // 목표 지점
            bfs.push([r, c]);
    }

while(bfsHead < bfs.length) { // 너비 우선 탐색
    const [startR, startC] = bfs[bfsHead++];
    for(const [moveR, moveC] of MOVE_DIR) {
        const endR = startR + moveR;
        const endC = startC + moveC;
        if(endR < 0 || endR >= n || endC < 0 || endC >= m)
            continue;
        if(graph[endR][endC] === 1) { // 갈 수 있음
            graph[endR][endC] = 0; // 방문 표시
            depths[endR][endC] = depths[startR][startC] + 1; // 깊이 계산
            bfs.push([endR, endC]);
        }
    }
}

console.log(depths.map((row) => row.join(" ")).join("\n"));