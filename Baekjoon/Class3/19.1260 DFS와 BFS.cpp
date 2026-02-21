#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

vector<vector<int>> graph;
vector<char> visited;

// 깊이 우선 탐색
void dfs_recursive(int start) {
    visited[start] = true;
    cout << start << ' ';
    for (int end : graph[start])
        if (!visited[end])
            dfs_recursive(end);
}

void dfs(int start) {
    visited = vector<char>(graph.size());
    dfs_recursive(start);
    cout << '\n';
}

// 너비 우선 탐색
void bfs(int start) {
    queue<int> q;
    visited = vector<char>(graph.size());
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

    graph = vector<vector<int>>(n + 1); // 무방향성 그래프
    while (m--) {
        int start, end;
        cin >> start >> end;
        graph[start].push_back(end);
        graph[end].push_back(start);
    }
    for (vector<int>& node : graph) // 정렬
        sort(node.begin(), node.end());

    dfs(v);
    bfs(v);

    return 0;
}