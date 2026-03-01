// 너비 우선 탐색
#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> graph(n + 1); // 무방향성 그래프
    while (m--) {
        int start, end;
        cin >> start >> end;
        graph[start].push_back(end);
        graph[end].push_back(start);
    }

    int min_kevin = INT_MAX;
    int min_kevin_idx = 0;
    for (int i = 1; i <= n; i++) {
        int kevin = 0;
        queue<int> bfs; // 너비 우선 탐색
        vector<int> depths(n + 1, -1);
        bfs.push(i);
        depths[i] = 0;
        while (!bfs.empty()) {
            int start = bfs.front();
            bfs.pop();
            for (int end : graph[start]) {
                if (depths[end] == -1) {
                    bfs.push(end);
                    depths[end] = depths[start] + 1;
                    kevin += depths[end]; // 케빈 베이컨 수 누적
                }
            }
        }
        if (min_kevin > kevin) {
            min_kevin = kevin;
            min_kevin_idx = i;
        }
    }

    cout << min_kevin_idx;
    return 0;
}

/* 플로이드-워셜
#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;
constexpr int MAX_USERS = 100;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> graph(n + 1, vector<int>(n + 1, MAX_USERS)); // 격자 그래프
    while (m--) {
        int start, end;
        cin >> start >> end;
        graph[start][end] = 1;
        graph[end][start] = 1;
    }

    for (int k = 1; k <= n; k++) // 모든 쌍 최단 경로
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]); // 지름길 찾기

    for (int i = 1; i <= n; i++) // 자기 자신에 대한 경로 0
        graph[i][i] = 0;

    int min_kevin = INT_MAX;
    int min_kevin_idx = 0;
    for (int i = 1; i <= n; i++) {
        int kevin = 0; // 케빈 베이컨 수 누적
        for (int j = 1; j <= n; j++)
            kevin += graph[i][j];
        if (min_kevin > kevin) {
            min_kevin = kevin;
            min_kevin_idx = i;
        }
    }
    cout << min_kevin_idx;
    return 0;
}
*/