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

    queue<Point> bfs;
    vector<string> campus;
    campus.reserve(n);
    for (int r = 0; r < n; r++) {
        string row;
        cin >> row;
        campus.push_back(row);
        size_t c = row.find('I'); // 시작점 찾기
        if (c != string::npos) {
            bfs.push({ r, int(c) });
            campus[r][c] = 'X'; // 방문 처리
        }
    }

    int people = 0; // 주변 사람 찾기
    while (!bfs.empty()) {
        Point start = bfs.front();
        bfs.pop();
        for (const Point& moveDir : MOVE_DIR) { // 모든 방향에 대해
            int end_r = start.r + moveDir.r;
            int end_c = start.c + moveDir.c;
            if (end_r < 0 || end_r >= n || end_c < 0 || end_c >= m) // 경계 확인
                continue;
            switch (campus[end_r][end_c]) {
            case 'P': // 사람 발견(fall-through)
                people++;
            case 'O': // 빈 공간으로 이동
                bfs.push({ end_r, end_c });
                campus[end_r][end_c] = 'X'; // 방문 처리
            }
        }
    }

    if (people == 0) cout << "TT";
    else cout << people;
    return 0;
}