const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);

const graph = Array.from({ length : n + 1 }, () => []); // 무방향성 그래프
for(let i = 1; i < n; i++) {
    const [start, end] = input[i].split(" ").map(Number);
    graph[start].push(end);
    graph[end].push(start);
}

const parents = new Array(n + 1).fill(0);
let bfsHead = 0;
const bfs = [1]; // 루트에서부터 너비 우선 탐색
parents[1] = -1;
while(bfsHead < bfs.length) {
    const start = bfs[bfsHead++];
    for(const end of graph[start])
        if(parents[end] === 0) { // 부모 설정
            parents[end] = start;
            bfs.push(end);
        }
}

console.log(parents.slice(2).join("\n"));