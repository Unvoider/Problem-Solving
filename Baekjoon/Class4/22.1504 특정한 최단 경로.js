const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const DIST_LIMIT = 500000000;

const findShortest = (dists, found) => {
    let minDist = DIST_LIMIT;
    let minIdx = -1;
    for(let i = 1; i < dists.length; i++)
        if(!found[i] && dists[i] < minDist) {
            minDist = dists[i];
            minIdx = i;
        }
    return minIdx;
};

const dijkstra = (begin, finish, graph) => {
    const size = graph.length;
    const dists = [...graph[begin]]; // begin에서부터 다른 노드로의 거리
    const found = new Array(size).fill(false);

    dists[begin] = 0; // 자기 자신에 대한 거리
    found[begin] = true;

    for(let i = 1; i < size - 1; i++) {
        const shortest = findShortest(dists, found); // begin에서부터 가장 거리가 짧은 노드 가져오기
        if(shortest === finish || shortest === -1) break;
        found[shortest] = true;
        for(let j = 1; j < size; j++) // 경유했을 때 기존 경로보다 짧으면 업데이트
            if(!found[j])
                dists[j] = Math.min(dists[j], dists[shortest] + graph[shortest][j]);
    }
    return dists[finish];

};

const [n, e] = input[0].split(" ").map(Number);

const graph = Array.from({ length : n + 1 }, () => new Array(n + 1).fill(DIST_LIMIT));
for(let i = 1; i <= e; i++) { // 인접 행렬 그래프
    const [a, b, c] = input[i].split(" ").map(Number);
    graph[a][b] = Math.min(graph[a][b], c);
    graph[b][a] = Math.min(graph[b][a], c);
}

const [v1, v2] = input[e + 1].split(" ").map(Number);
const fromV1ToV2 = dijkstra(1, v1, graph) + dijkstra(v1, v2, graph) + dijkstra(v2, n, graph);
const fromV2ToV1 = dijkstra(1, v2, graph) + dijkstra(v2, v1, graph) + dijkstra(v1, n, graph);
if(fromV1ToV2 >= DIST_LIMIT && fromV2ToV1 >= DIST_LIMIT) // 경로 없음
    console.log(-1);
else // v1, v2를 경유
    console.log(Math.min(fromV1ToV2, fromV2ToV1));