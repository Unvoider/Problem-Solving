#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int count_components(const vector<vector<int>>& graph) {
    int count = 0;
    queue<int> bfs;
    vector<char> visited(graph.size());
    for (int i = 1; i < graph.size(); i++) {
        if (visited[i]) continue;
        bfs.push(i); // 컴포넌트 발견
        visited[i] = true;
        count++;
        while (!bfs.empty()) {
            int start = bfs.front();
            bfs.pop();
            for (int end : graph[start]) {
                if (!visited[end]) {
                    bfs.push(end);
                    visited[end] = true;
                }
            }
        }
    }
    return count++;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> graph(n + 1); // 무방향성 그래프
    while (m--) {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    cout << count_components(graph);
    return 0;
}