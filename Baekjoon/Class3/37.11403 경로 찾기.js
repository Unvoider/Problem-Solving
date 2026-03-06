// 너비 우선 탐색
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);

const graph = Array.from({ length : n }, () => []); // 인접 리스트
for(let i = 0; i < n; i++) { // 직접 경로
    const row = input[i + 1].trim().split(" ");
    for(let j = 0; j < n; j++)
        if(row[j] === "1")
            graph[i].push(j);
}

const visited = Array.from({ length : n }, () => new Array(n).fill(0));
for(let node = 0; node < n; node++) { // 매 노드마다 모든 경로 찾기
    let bfsHead = 0;
    const bfs = [node];
    while(bfsHead < bfs.length) {
        start = bfs[bfsHead++];
        for(const end of graph[start])
            if(visited[node][end] === 0) {
                visited[node][end] = 1;
                bfs.push(end);
            }
    }
}

console.log(visited.map((row) => row.join(" ")).join("\n"));

/* 플로이드-워셜
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);

const graph = []; // 인접 행렬
for(let i = 1; i <= n; i++) // 직접 경로
    graph.push(input[i].split(" ").map(Number));

for(let k = 0; k < n; k++) // 간접 경로
    for(let i = 0; i < n; i++)
        for(let j = 0; j < n; j++)
            if(graph[i][k] && graph[k][j])
                graph[i][j] = 1;

console.log(graph.map((row) => row.join(" ")).join("\n"));
*/