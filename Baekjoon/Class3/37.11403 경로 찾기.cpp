// 너비 우선 탐색
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<vector<char>> graph(n); // 인접 리스트
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) {
            char link;
            cin >> link;
            if (link == '1')
                graph[i].push_back(j);
        }

    vector<vector<char>> visited(n, vector<char>(n, '0'));
    for (int node = 0; node < n; node++) { // 매 노드마다 모든 경로 찾기
        queue<int> bfs;
        bfs.push(node);
        while (!bfs.empty()) {
            int start = bfs.front();
            bfs.pop();
            for (int end : graph[start])
                if (visited[node][end] == '0') {
                    visited[node][end] = '1';
                    bfs.push(end);
                }
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            cout << visited[i][j] << ' ';
        cout << '\n';
    }
    return 0;
}

/* 플로이드-워셜
#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<vector<short>> graph(n, vector<short>(n)); // 인접 행렬
    for (int i = 0; i < n; i++) // 직접 경로
        for (int j = 0; j < n; j++)
            cin >> graph[i][j];

    for (int k = 0; k < n; k++) // 간접 경로
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if(graph[i][k] & graph[k][j])
                    graph[i][j] = 1;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            cout << graph[i][j] << ' ';
        cout << '\n';
    }
    return 0;
}
*/