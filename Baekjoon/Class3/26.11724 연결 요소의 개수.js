const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const countComponents = (graph) => {
    let count = 0;
    const visited = new Array(graph.length).fill(false);
    for(let i = 1; i < graph.length; i++) {
        if(visited[i]) continue;
        let bfsHead = 0; // 컴포넌트 발견
        const bfs = [i];
        visited[i] = true;
        count++;
        while(bfsHead < bfs.length) {
            const start = bfs[bfsHead++];
            for(const end of graph[start]) {
                if(!visited[end]) {
                    bfs.push(end);
                    visited[end] = true;
                }
            }
        }
    }
    return count;
}

const [n, m] = input[0].split(" ").map(Number);
const graph = Array.from({ length: n + 1 }, () => []);

for(let i = 1; i <= m; i++) { // 무방향성 그래프
    const [u, v] = input[i].split(" ").map(Number);
    graph[u].push(v);
    graph[v].push(u);
}

console.log(countComponents(graph));