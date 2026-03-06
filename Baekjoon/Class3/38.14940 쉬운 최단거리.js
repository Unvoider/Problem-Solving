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
for(let i = 0; i < n; i++)
    for(let j = 0; j < m; j++) {
        const num = graph[i][j]
        if(num === 1)
            depths[i][j] = -1;
        else if(num === 2) // 목표 지점
            bfs.push([i, j]);
    }

while(bfsHead < bfs.length) { // 너비 우선 탐색
    const [startX, startY] = bfs[bfsHead++];
    for(const [moveX, moveY] of MOVE_DIR) {
        const endX = startX + moveX;
        const endY = startY + moveY;
        if(endX < 0 || endX >= n || endY < 0 || endY >= m)
            continue;
        if(graph[endX][endY] === 1) { // 갈 수 있음
            graph[endX][endY] = 0; // 방문 표시
            depths[endX][endY] = depths[startX][startY] + 1; // 깊이 계산
            bfs.push([endX, endY]);
        }
    }
}

console.log(depths.map((row) => row.join(" ")).join("\n"));