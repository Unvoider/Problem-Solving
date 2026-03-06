#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct Point {
    short x, y;
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
    for (short i = 0; i < n; i++)
        for (short j = 0; j < m; j++) {
            int num;
            cin >> num;
            graph[i][j] = num;
            if (num == 1)
                depths[i][j] = -1;
            else if (num == 2) // 목표 지점
                bfs.push({ i, j });
        }

    while (!bfs.empty()) { // 너비 우선 탐색
        Point start = bfs.front();
        bfs.pop();
        for (const Point& move_dir : MOVE_DIR) {
            short end_x = start.x + move_dir.x;
            short end_y = start.y + move_dir.y;
            if (end_x < 0 || end_x >= n || end_y < 0 || end_y >= m)
                continue;
            if (graph[end_x][end_y] == 1) { // 갈 수 있음
                graph[end_x][end_y] = 0; // 방문 표시
                depths[end_x][end_y] = depths[start.x][start.y] + 1; // 깊이 계산
                bfs.push({ end_x, end_y });
            }
        }
    }

    for (short i = 0; i < n; i++) {
        for (short j = 0; j < m; j++)
            cout << depths[i][j] << ' ';
        cout << '\n';
    }
    return 0;
}