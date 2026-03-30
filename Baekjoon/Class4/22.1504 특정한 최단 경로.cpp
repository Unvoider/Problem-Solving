#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
constexpr int DIST_LIMIT = 500000000;

struct Edge {
    int end, weight;
    Edge(int end, int weight) : end(end), weight(weight) {}
    bool operator>(const Edge& other) const {
        return weight > other.weight;
    }
};

vector<vector<Edge>> graph;

int dijkstra(int begin, int finish) {
    int size = graph.size();
    vector<int> dists(size, DIST_LIMIT); // begin에서부터 다른 노드로의 거리
    priority_queue<Edge, vector<Edge>, greater<Edge>> pq; // 최소 힙

    dists[begin] = 0; // 자기 자신에 대한 거리
    pq.push(Edge(begin, 0));

    while (!pq.empty()) {
        int shortest_end = pq.top().end; // begin에서부터 가장 거리가 짧은 노드 가져오기
        if (shortest_end == finish) break;
        pq.pop();
        for (const Edge& adjacent : graph[shortest_end]) { // 해당 노드의 인접 노드 확인
            int via_end = adjacent.end;
            int via_dist = dists[shortest_end] + adjacent.weight;
            if (via_dist < dists[via_end]) { // 경유했을 때 기존 경로보다 짧으면 업데이트 및 추가
                dists[via_end] = via_dist;
                pq.push(Edge(via_end, via_dist));
            }
        }
    }
    return dists[finish];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, e;
    cin >> n >> e;

    graph = vector<vector<Edge>>(n + 1); // 무방향성 그래프
    while (e--) {
        int a, b, c;
        cin >> a >> b >> c;
        graph[a].emplace_back(b, c);
        graph[b].emplace_back(a, c);
    }

    int v1, v2;
    cin >> v1 >> v2;
    int from_v1_to_v2 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
    int from_v2_to_v1 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);
    if (from_v1_to_v2 >= DIST_LIMIT && from_v2_to_v1 >= DIST_LIMIT) // 경로 없음
        cout << -1;
    else // v1, v2를 경유
        cout << min(from_v1_to_v2, from_v2_to_v1);
    return 0;
}