// 너비 우선 탐색
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);

const graph = Array.from({ length : n + 1 }, () => []); // 무방향성 그래프
for(let i = 1; i <= m; i++) {
    const [start, end] = input[i].split(" ").map(Number);
    graph[start].push(end);
    graph[end].push(start);
}

let minKevin = Number.MAX_VALUE;
let minKevinIdx = 0;
for(let i = 1; i <= n; i++) {
    let kevin = 0;
    let bfsHead = 0;
    const bfs = []; // 너비 우선 탐색
    const depths = new Array(n + 1).fill(-1);
    bfs.push(i);
    depths[i] = 0;
    while(bfsHead < bfs.length) {
        const start = bfs[bfsHead++];
        for(const end of graph[start]) {
            if(depths[end] === -1) {
                bfs.push(end);
                depths[end] = depths[start] + 1;
                kevin += depths[end]; // 케빈 베이컨 수 누적
            }
        }
    }
    if(minKevin > kevin) {
        minKevin = kevin;
        minKevinIdx = i;
    }
}

console.log(minKevinIdx);


/* 플로이드-워셜
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const MAX_USERS = 100;

const [n, m] = input[0].split(" ").map(Number);

const graph = Array.from({ length : n + 1 }, () => new Array(n + 1).fill(MAX_USERS));
for(let i = 1; i <= m; i++) {
    const [start, end] = input[i].split(" ").map(Number);
    graph[start][end] = 1;
    graph[end][start] = 1;
}

for(let k = 1; k <= n; k++) // 모든 쌍 최단 경로
    for(let i = 1; i <= n; i++)
        for(let j = 1; j <= n; j++)
            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]); // 지름길 찾기

for(let i = 1; i <= n; i++) // 자기 자신에 대한 경로 0
    graph[i][i] = 0;

let minKevin = Number.MAX_VALUE;
let minKevinIdx = 0;
for(let i = 1; i <= n; i++) {
    const kevin = graph[i].slice(1).reduce((acc, cur) => acc + cur); // 케빈 베이컨 수 누적
    if(minKevin > kevin) {
        minKevin = kevin;
        minKevinIdx = i;
    }
}
console.log(minKevinIdx);
*/