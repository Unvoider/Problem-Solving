#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
constexpr int DISTANCE_LIMIT = 100000000;

struct Bus {
    int end, cost;
    Bus(int end, int cost) : end(end), cost(cost) {}
    bool operator<(const Bus& other) const {
        return cost > other.cost;
    }
};

vector<vector<Bus>> graph;

int dijkstra(int begin, int finish) {
    int size = graph.size();
    vector<int> costs(size, DISTANCE_LIMIT); // begin에서부터 다른 노드로의 비용
    priority_queue<Bus> pq; // 최소 힙

    costs[begin] = 0; // 자기 자신에 대한 비용
    pq.emplace(begin, 0);

    while (!pq.empty()) {
        int shortest_end = pq.top().end; // begin에서부터 가장 비용이 적은 노드 가져오기
        if (shortest_end == finish) break;
        pq.pop();
        for (const Bus& adjacent : graph[shortest_end]) { // 해당 노드의 인접 노드 확인
            int via_end = adjacent.end;
            int via_cost = costs[shortest_end] + adjacent.cost;
            if (via_cost < costs[via_end]) { // 경유했을 때 기존 경로보다 싸면 업데이트 및 추가
                costs[via_end] = via_cost;
                pq.emplace(via_end, via_cost);
            }
        }
    }
    return costs[finish];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    graph = vector<vector<Bus>>(n + 1); // 방향성 그래프
    while (m--) {
        int start, end, cost;
        cin >> start >> end >> cost;
        graph[start].emplace_back(end, cost);
    }

    int begin, finish;
    cin >> begin >> finish;
    cout << dijkstra(begin, finish);
    return 0;
}