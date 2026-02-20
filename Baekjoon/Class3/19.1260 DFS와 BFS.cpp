#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

// 깊이 우선 탐색
void dfs_(int start, const vector<vector<int>>& graph, vector<char>& visited) {
    for (int end : graph[start])
        if (!visited[end]) {
            visited[end] = true;
            cout << end << ' ';
            dfs_(end, graph, visited);
        }
}

void dfs(int start, const vector<vector<int>>& graph) {
    vector<char> visited(graph.size());
    visited[start] = true;
    cout << start << ' ';
    dfs_(start, graph, visited);
    cout << '\n';
}

// 너비 우선 탐색
void bfs(int start, const vector<vector<int>>& graph) {
    queue<int> q;
    vector<char> visited(graph.size());
    q.push(start);
    visited[start] = true;
    cout << start << ' ';
    while (!q.empty()) {
        start = q.front();
        q.pop();
        for (int end : graph[start])
            if (!visited[end]) {
                q.push(end);
                visited[end] = true;
                cout << end << ' ';
            }
    }
    cout << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m, v;
    cin >> n >> m >> v;

    vector<vector<int>> graph(n + 1); // 무방향성 그래프
    while (m--) {
        int start, end;
        cin >> start >> end;
        graph[start].push_back(end);
        graph[end].push_back(start);
    }
    for (vector<int>& node : graph) // 정렬
        sort(node.begin(), node.end());

    dfs(v, graph);
    bfs(v, graph);

    return 0;
}