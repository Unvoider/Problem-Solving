#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

struct Point {
    int x, y;
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
    for (int x = 0; x < n; x++)
        for (int y = 0; y < n; y++)
            if (houses[x][y] == HOUSE) { // 집이 있음
                int house_count = 1;
                bfs.push({ x, y });
                houses[x][y] = EMPTY;
                while (!bfs.empty()) { // 인접한 집 확인
                    const Point start = bfs.front();
                    bfs.pop();
                    for (const Point& move_dir : MOVE_DIR) {
                        int end_x = start.x + move_dir.x;
                        int end_y = start.y + move_dir.y;
                        if (end_x < 0 || end_x >= n || end_y < 0 || end_y >= n)
                            continue;
                        if (houses[end_x][end_y] == HOUSE) { // 인접한 집이 있음
                            house_count++;
                            bfs.push({ end_x, end_y });
                            houses[end_x][end_y] = EMPTY;
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