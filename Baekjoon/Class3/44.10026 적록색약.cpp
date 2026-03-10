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

class CountColorArea {
private:
    int area_count = 0;
public:
    template <typename F>
    CountColorArea(const vector<string>& colors, F is_equal) {
        int n = colors.size();
        vector<vector<char>> visited(n, vector<char>(n, false));
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++)
                if (!visited[r][c]) { // 처음 발견한 색
                    char current_color = colors[r][c];
                    area_count++; // 개수 세기
                    queue<Point> bfs; // 너비 우선 탐색
                    bfs.push({ r, c });
                    visited[r][c] = true;
                    while (!bfs.empty()) {
                        Point start = bfs.front();
                        bfs.pop();
                        for (const Point& move_dir : MOVE_DIR) {
                            int end_r = start.r + move_dir.r;
                            int end_c = start.c + move_dir.c;
                            if (end_r < 0 || end_r >= n || end_c < 0 || end_c >= n)
                                continue;
                            // 주변 같은 색 발견
                            if (!visited[end_r][end_c] && is_equal(current_color, colors[end_r][end_c])) {
                                bfs.push({ end_r, end_c });
                                visited[end_r][end_c] = true;
                            }
                        }
                    }
                }
    }
    int get_count() const {
        return area_count;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<string> colors(n); // 격자 그래프
    for (int i = 0; i < n; i++)
        cin >> colors[i];

    cout << CountColorArea(colors, [](char color1, char color2) { // 일반 비교 함수
        return color1 == color2;
    }).get_count() << ' ';
    cout << CountColorArea(colors, [](char color1, char color2) { // 색맹 비교 함수
        return color1 == color2
            || color1 == 'R' && color2 == 'G'
            || color1 == 'G' && color2 == 'R';
    }).get_count();
    return 0;
}