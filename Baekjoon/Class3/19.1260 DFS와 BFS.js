const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/).map(Number);

// 깊이 우선 탐색
const dfs_ = (start, graph, visited, out) => {
    for(const end of graph[start])
        if(!visited[end]) {
            visited[end] = true;
            out.push(end);
            dfs_(end, graph, visited, out);
        }
}

const dfs = (start, graph, out) => {
    const visited = new Array(graph.length).fill(false);
    visited[start] = true;
    out.push(start);
    dfs_(start, graph, visited, out);
}

// 너비 우선 탐색
const bfs = (start, graph, out) => {
    let qHead = 0;
    const q = [start];
    const visited = new Array(graph.length).fill(false);
    visited[start] = true;
    out.push(start);
    while(qHead < q.length) {
        const start = q[qHead++];
        for(const end of graph[start])
            if(!visited[end]) {
                q.push(end);
                visited[end] = true;
                out.push(end);
            }
    }
}

let cursor = 0;
const n = input[cursor++];
const m = input[cursor++];
const v = input[cursor++];

graph = Array.from({ length: n + 1 }, () => new Array()); // 무방향성 그래프
for(let _ = 0; _ < m; _++) {
    const start = input[cursor++];
    const end = input[cursor++];
    graph[start].push(end);
    graph[end].push(start);
}
for(const node of graph) // 정렬
    node.sort((a, b) => a - b);

const out = []
dfs(v, graph, out);
console.log(out.join(" "));

out.length = 0;
bfs(v, graph, out);
console.log(out.join(" "));