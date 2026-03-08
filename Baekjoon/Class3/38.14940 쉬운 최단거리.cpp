#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct Point {
    short r, c;
};
constexpr Point MOVE_DIR[] = {
    {-1, 0},
    {1, 0},
    {0, -1},
    {0, 1}
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    short n, m;
    cin >> n >> m;

    vector<vector<short>> graph(n, vector<short>(m)); // 격자 그래프
    vector<vector<short>> depths(n, vector<short>(m));
    queue<Point> bfs;
    for (short r = 0; r < n; r++)
        for (short c = 0; c < m; c++) {
            int num;
            cin >> num;
            graph[r][c] = num;
            if (num == 1)
                depths[r][c] = -1;
            else if (num == 2) // 목표 지점
                bfs.push({ r, c });
        }

    while (!bfs.empty()) { // 너비 우선 탐색
        Point start = bfs.front();
        bfs.pop();
        for (const Point& move_dir : MOVE_DIR) {
            short end_r = start.r + move_dir.r;
            short end_c = start.c + move_dir.c;
            if (end_r < 0 || end_r >= n || end_c < 0 || end_c >= m)
                continue;
            if (graph[end_r][end_c] == 1) { // 갈 수 있음
                graph[end_r][end_c] = 0; // 방문 표시
                depths[end_r][end_c] = depths[start.r][start.c] + 1; // 깊이 계산
                bfs.push({ end_r, end_c });
            }
        }
    }

    for (short r = 0; r < n; r++) {
        for (short c = 0; c < m; c++)
            cout << depths[r][c] << ' ';
        cout << '\n';
    }
    return 0;
}