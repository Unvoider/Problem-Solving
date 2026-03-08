#include <iostream>
#include <utility>
#include <vector>
#include <queue>
using namespace std;
constexpr pair<int, int> MOVE_DIR[4] = {
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
        int r, c;
        cin >> r >> c;
        graph[r][c] = true;
    }

    queue<pair<int, int>> bfs;
    int components = 0;
    for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
            if (graph[r][c]) { // 연결 요소 시작점 찾기
                bfs.push({ r, c });
                graph[r][c] = false;
                components++;
            }
            while (!bfs.empty()) { // 너비 우선 탐색
                const pair<int, int>& start = bfs.front();
                bfs.pop();
                for (const pair<int, int>& move_dir : MOVE_DIR) {
                    int end_r = start.first + move_dir.first;
                    int end_c = start.second + move_dir.second;
                    if (end_r < 0 || end_r >= m || end_c < 0 || end_c >= n)
                        continue;
                    if (graph[end_r][end_c]) {
                        bfs.push({ end_r, end_c });
                        graph[end_r][end_c] = false;
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