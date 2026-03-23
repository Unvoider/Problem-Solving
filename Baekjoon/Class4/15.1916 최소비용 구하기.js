const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const DISTANCE_LIMIT = 100000000;

const findShortest = (costs, found) => {
    let minCost = DISTANCE_LIMIT;
    let minIdx = -1;
    for(let i = 1; i < costs.length; i++)
        if(!found[i] && costs[i] < minCost) {
            minCost = costs[i];
            minIdx = i;
        }
    return minIdx;
};

const dijkstra = (begin, finish, graph) => {
    const size = graph.length;
    const costs = [...graph[begin]]; // begin에서부터 다른 노드로의 비용
    const found = new Array(size).fill(false);

    costs[begin] = 0; // 자기 자신에 대한 비용
    found[begin] = true;

    for(let i = 1; i < size - 1; i++) {
        const shortest = findShortest(costs, found); // begin에서부터 가장 비용이 적은 노드 가져오기
        if(shortest === finish || shortest === -1) break;
        found[shortest] = true;
        for(let j = 1; j < size; j++) // 경유했을 때 기존 경로보다 싸면 업데이트
            if(!found[j])
                costs[j] = Math.min(costs[j], costs[shortest] + graph[shortest][j]);
    }
    return costs[finish];

};

const n = Number(input[0]);
const m = Number(input[1]);

const graph = Array.from({ length : n + 1 }, () => new Array(n + 1).fill(DISTANCE_LIMIT));
for(let i = 2; i <= m + 1; i++) { // 인접 행렬 그래프
    const [start, end, cost] = input[i].split(" ").map(Number);
    graph[start][end] = Math.min(graph[start][end], cost);
}

const [begin, finish] = input[m + 2].split(" ").map(Number);
console.log(dijkstra(begin, finish, graph));