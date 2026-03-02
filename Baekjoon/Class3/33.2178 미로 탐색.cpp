#include <iostream>
#include <string>
#include <vector>
#include <queue>
using namespace std;

struct Point {
    int x, y;
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

    int n, m;
    cin >> n >> m;

    vector<vector<int>> depths(n, vector<int>(m, 0)); // 벽 0
    for (int x = 0; x < n; x++) {
        string row;
        cin >> row;
        for (int y = 0; y < m; y++)
            if (row[y] == '1')
                depths[x][y] = -1; // 길 -1
    }

    queue<Point> bfs; // 너비 우선 탐색
    bfs.push({ 0, 0 }); // 출발 위치 { 0, 0 }
    depths[0][0] = 1; // 출발 깊이 1
    while (true) {
        const Point start = bfs.front();
        bfs.pop();
        if (start.x == n - 1 && start.y == m - 1) // 도착 위치 { n - 1, m - 1 }
            break;
        for (const Point& move_dir : MOVE_DIR) {
            int end_x = start.x + move_dir.x;
            int end_y = start.y + move_dir.y;
            if (end_x < 0 || end_x >= n || end_y < 0 || end_y >= m) // 경계 확인
                continue;
            if (depths[end_x][end_y] == -1) { // 이동
                bfs.push({ end_x, end_y });
                depths[end_x][end_y] = depths[start.x][start.y] + 1;
            }
        }
    }

    cout << depths[n - 1][m - 1]; // 도착 깊이
    return 0;
}