#include <iostream>
#include <utility>
#include <vector>
#include <queue>
using namespace std;
constexpr int MOVE_DIR[4][2] = {
    {-1, 0},
    {1, 0},
    {0, -1},
    {0, 1}
};

void count_worms() {
    int m, n, k;
    cin >> m >> n >> k;

    vector<vector<char>> graph(m, vector<char>(n)); // 격자 그래프
    while (k--) {
        int x, y;
        cin >> x >> y;
        graph[x][y] = true;
    }

    queue<pair<int, int>> bfs;
    int components = 0;
    for (int x = 0; x < m; x++) {
        for (int y = 0; y < n; y++) {
            if (graph[x][y]) { // 연결 요소 시작점 찾기
                bfs.push({ x, y });
                graph[x][y] = false;
                components++;
            }
            while (!bfs.empty()) { // 너비 우선 탐색
                const pair<int, int>& start = bfs.front();
                bfs.pop();
                for (int i = 0; i < 4; i++) {
                    int end_x = start.first + MOVE_DIR[i][0];
                    int end_y = start.second + MOVE_DIR[i][1];
                    if (end_x >= 0 && end_x < m && end_y >= 0 && end_y < n)
                        if (graph[end_x][end_y]) {
                            bfs.push({ end_x, end_y });
                            graph[end_x][end_y] = false;
                        }
                }
            }
        }
    }
    cout << components << '\n'; // 연결 요소 수
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--)
        count_worms();
    return 0;
}