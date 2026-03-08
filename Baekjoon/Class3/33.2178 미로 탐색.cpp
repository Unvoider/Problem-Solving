#include <iostream>
#include <string>
#include <vector>
#include <queue>
using namespace std;

struct Point {
    int r, c;
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
    for (int r = 0; r < n; r++) {
        string row;
        cin >> row;
        for (int c = 0; c < m; c++)
            if (row[c] == '1')
                depths[r][c] = -1; // 길 -1
    }

    queue<Point> bfs; // 너비 우선 탐색
    bfs.push({ 0, 0 }); // 출발 위치 { 0, 0 }
    depths[0][0] = 1; // 출발 깊이 1
    while (true) {
        const Point start = bfs.front();
        bfs.pop();
        if (start.r == n - 1 && start.c == m - 1) // 도착 위치 { n - 1, m - 1 }
            break;
        for (const Point& move_dir : MOVE_DIR) {
            int end_r = start.r + move_dir.r;
            int end_c = start.c + move_dir.c;
            if (end_r < 0 || end_r >= n || end_c < 0 || end_c >= m) // 경계 확인
                continue;
            if (depths[end_r][end_c] == -1) { // 이동
                bfs.push({ end_r, end_c });
                depths[end_r][end_c] = depths[start.r][start.c] + 1;
            }
        }
    }

    cout << depths[n - 1][m - 1]; // 도착 깊이
    return 0;
}