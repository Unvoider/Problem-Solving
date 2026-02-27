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

    queue<Point> bfs;
    vector<string> campus;
    campus.reserve(n);
    for (int x = 0; x < n; x++) {
        string row;
        cin >> row;
        campus.push_back(row);
        size_t y = row.find('I'); // 시작점 찾기
        if (y != string::npos) {
            bfs.push({ x, int(y) });
            campus[x][y] = 'X'; // 방문 처리
        }
    }

    int people = 0; // 주변 사람 찾기
    while (!bfs.empty()) {
        Point start = bfs.front();
        bfs.pop();
        for (const Point& moveDir : MOVE_DIR) { // 모든 방향에 대해
            int end_x = start.x + moveDir.x;
            int end_y = start.y + moveDir.y;
            if (end_x < 0 || end_x >= n || end_y < 0 || end_y >= m) // 경계 확인
                continue;
            switch (campus[end_x][end_y]) {
            case 'P': // 사람 발견(fall-through)
                people++;
            case 'O': // 빈 공간으로 이동
                bfs.push({ end_x, end_y });
                campus[end_x][end_y] = 'X'; // 방문 처리
            }
        }
    }

    if (people == 0) cout << "TT";
    else cout << people;
    return 0;
}