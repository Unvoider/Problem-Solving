#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct Point {
    int p, r, c; // page, row, column
};
constexpr Point MOVE_DIR[] = {
    {-1, 0, 0},
    {1, 0, 0},
    {0, -1, 0},
    {0, 1, 0},
    {0, 0, -1},
    {0, 0, 1}
};
constexpr int NO_TOMATO = -1;
constexpr int UNRIPE_TOMATO = -2;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int m, n, h;
    cin >> m >> n >> h;

    int unripe_tomato_count = 0;
    int ripe_time = 0;
    vector<vector<vector<int>>> depths(h, vector<vector<int>>(n, vector<int>(m, NO_TOMATO))); // 격자 그래프
    queue<Point> bfs;
    for (int p = 0; p < h; p++)
        for (int r = 0; r < n; r++)
            for (int c = 0; c < m; c++) {
                int tomato;
                cin >> tomato;
                if (tomato == 1) { // 익음
                    bfs.push({ p, r, c });
                    depths[p][r][c] = 0;
                }
                else if (tomato == 0) { // 익지 않음
                    depths[p][r][c] = UNRIPE_TOMATO;
                    unripe_tomato_count++;
                }
            }

    while (!bfs.empty()) { // 너비 우선 탐색
        Point start = bfs.front();
        bfs.pop();
        for (const Point& move_dir : MOVE_DIR) {
            int end_p = start.p + move_dir.p;
            int end_r = start.r + move_dir.r;
            int end_c = start.c + move_dir.c;
            if (end_p < 0 || end_p >= h || end_r < 0 || end_r >= n || end_c < 0 || end_c >= m)
                continue;
            if (depths[end_p][end_r][end_c] == UNRIPE_TOMATO) { // 인접 토마토가 익지 않음
                bfs.push({ end_p, end_r, end_c }); // 익히기
                ripe_time = depths[end_p][end_r][end_c] = depths[start.p][start.r][start.c] + 1;
                unripe_tomato_count--;
            }
        }
    }

    if (unripe_tomato_count == 0)
        cout << ripe_time;
    else
        cout << -1;
    return 0;
}