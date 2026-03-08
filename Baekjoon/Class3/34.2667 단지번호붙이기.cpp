#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

struct Point {
    int r, c;
};
constexpr Point MOVE_DIR[] = {
    {-1, 0},
    {1, 0},
    {0, -1},
    {0, 1},
};
constexpr char HOUSE = '1';
constexpr char EMPTY = '0';

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<string> houses(n);
    for (int i = 0; i < n; i++)
        cin >> houses[i];

    vector<int> house_counts;
    queue<Point> bfs; // 너비 우선 탐색
    for (int r = 0; r < n; r++)
        for (int c = 0; c < n; c++)
            if (houses[r][c] == HOUSE) { // 집이 있음
                int house_count = 1;
                bfs.push({ r, c });
                houses[r][c] = EMPTY;
                while (!bfs.empty()) { // 인접한 집 확인
                    const Point start = bfs.front();
                    bfs.pop();
                    for (const Point& move_dir : MOVE_DIR) {
                        int end_r = start.r + move_dir.r;
                        int end_c = start.c + move_dir.c;
                        if (end_r < 0 || end_r >= n || end_c < 0 || end_c >= n)
                            continue;
                        if (houses[end_r][end_c] == HOUSE) { // 인접한 집이 있음
                            house_count++;
                            bfs.push({ end_r, end_c });
                            houses[end_r][end_c] = EMPTY;
                        }
                    }
                }
                house_counts.push_back(house_count);
            }

    sort(house_counts.begin(), house_counts.end()); // 오름차순 정렬
    cout << house_counts.size() << '\n'; // 단지 수
    for (int house_count : house_counts) // 단지당 집 수
        cout << house_count << '\n';
    return 0;
}