#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<vector<int>> graph(n + 1); // 무방향성 그래프
    for (int _ = 1; _ < n; _++) {
        int start, end;
        cin >> start >> end;
        graph[start].push_back(end);
        graph[end].push_back(start);
    }

    vector<int> parents(n + 1);
    queue<int> bfs;
    bfs.push(1); // 루트에서부터 너비 우선 탐색
    parents[1] = -1;
    while (!bfs.empty()) {
        int start = bfs.front();
        bfs.pop();
        for (int end : graph[start])
            if (parents[end] == 0) { // 부모 설정
                parents[end] = start;
                bfs.push(end);
            }
    }

    for (int i = 2; i <= n; i++)
        cout << parents[i] << '\n';
    return 0;
}