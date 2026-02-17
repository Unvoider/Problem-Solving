// 너비 우선 탐색
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int pc_n, link_n;
    cin >> pc_n >> link_n;

    vector<vector<int>> graph(pc_n + 1); // 무방향성 그래프
    while (link_n--) {
        int start, end;
        cin >> start >> end;
        graph[start].push_back(end);
        graph[end].push_back(start);
    }

    queue<int> bfs;
    vector<char> visited(pc_n + 1);
    bfs.push(1); // 1번 감염
    visited[1] = true;
    int infected_count = 1;
    while (!bfs.empty()) {
        int start = bfs.front();
        bfs.pop();
        for (int end : graph[start])
            if (!visited[end]) {
                bfs.push(end);
                visited[end] = true;
                infected_count++;
            }
    }
    cout << infected_count - 1;
    return 0;
}

/* 깊이 우선 탐색
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int>> graph;
vector<char> visited;

void dfs(int start) {
    for (int end : graph[start])
        if (!visited[end]) {
            visited[end] = true;
            dfs(end);
        }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int pc_n, link_n;
    cin >> pc_n >> link_n;

    graph = vector<vector<int>>(pc_n + 1); // 무방향성 그래프
    while (link_n--) {
        int start, end;
        cin >> start >> end;
        graph[start].push_back(end);
        graph[end].push_back(start);
    }

    visited = vector<char>(pc_n + 1);
    visited[1] = true; // 1번 감염
    dfs(1);
    cout << count(visited.begin(), visited.end(), true) - 1;
    return 0;
}
*/