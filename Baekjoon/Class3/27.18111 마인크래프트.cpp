#include <iostream>
#include <climits>
using namespace std;
constexpr int HEIGHT_LIMIT = 256;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m, b;
    cin >> n >> m >> b;

    int min_h = HEIGHT_LIMIT, max_h = 0;
    int height_counts[HEIGHT_LIMIT + 1] = {};
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++) {
            int h;
            cin >> h;
            if (min_h > h) min_h = h;
            if (max_h < h) max_h = h;
            height_counts[h]++;
        }

    int min_time = INT_MAX, flat_h = 0;
    for (int target_h = min_h; target_h <= max_h; target_h++) { // 모든 높이 확인
        int to_place = 0, to_break = 0; // 해당 높이에서 설치/삭제해야 하는 블록 수
        for (int cur_h = min_h; cur_h <= max_h; cur_h++) {
            int blocks = target_h - cur_h;
            if (blocks > 0)
                to_place += blocks * height_counts[cur_h];
            else if (blocks < 0)
                to_break -= blocks * height_counts[cur_h];
        }
        if (b + to_break >= to_place) { // 인벤토리 블록 수 확인
            int time = to_break * 2 + to_place;
            if (min_time >= time) { // 최소 시간 갱신
                min_time = time;
                flat_h = target_h;
            }
        }
    }

    cout << min_time << ' ' << flat_h;
    return 0;
}