// 너비 우선 탐색
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/).map(Number);

const pcN = input[0];
const linkN = input[1];

let cursor = 2;
const graph = Array.from({ length: pcN + 1 }, () => []); // 무방향성 그래프
for(let _ = 0; _ < linkN; _++) {
    const start = input[cursor++];
    const end = input[cursor++];
    graph[start].push(end);
    graph[end].push(start);
}

let bfsHead = 0;
const bfs = [1]; // 1번 감염
const visited = new Array(pcN + 1).fill(false);
visited[1] = true;
let infectedCount = 1;
while(bfs.length > bfsHead) {
    const start = bfs[bfsHead++];
    for(const end of graph[start])
        if(!visited[end]) {
            bfs.push(end);
            visited[end] = true;
            infectedCount++;
        }
}
console.log(infectedCount - 1);

/* 깊이 우선 탐색
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/).map(Number);

const dfs = (start, graph, visited) => {
    for(const end of graph[start])
        if(!visited[end]) {
            visited[end] = true;
            dfs(end, graph, visited);
        }
}

const pcN = input[0];
const linkN = input[1];

let cursor = 2;
const graph = Array.from({ length: pcN + 1 }, () => []); // 무방향성 그래프
for(let _ = 0; _ < linkN; _++) {
    const start = input[cursor++];
    const end = input[cursor++];
    graph[start].push(end);
    graph[end].push(start);
}

const visited = new Array(pcN + 1).fill(false);
visited[1] = true; // 1번 감염
dfs(1, graph, visited);
console.log(visited.filter((val) => val).length - 1);
*/