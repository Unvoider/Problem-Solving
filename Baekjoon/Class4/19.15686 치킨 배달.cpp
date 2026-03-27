#include <iostream>
#include <utility>
#include <vector>
using namespace std;
constexpr int MAX_DIST = 1000000000;

struct Point {
    int r, c;
    Point(int r, int c) : r(r), c(c) {};
};

int n, m; // 행렬 크기, 폐업시키지 않을 치킨 집 수
vector<Point> houses, chickens;
vector<char> is_open;
vector<vector<int>> chinken_dists;
int chicken_dist = MAX_DIST;

void choose_chickens(int cur, int count) {
    if (count == m) { // m개 선택됨
        int total_min_dist = 0;
        for (int i = 0; i < houses.size(); i++) { // 각 집과 열린 치킨집의 최소 거리 누적
            int min_dist = MAX_DIST;
            for (int j = 0; j < chickens.size(); j++)
                if (is_open[j])
                    min_dist = min(min_dist, chinken_dists[i][j]);
            total_min_dist += min_dist;
        }
        chicken_dist = min(chicken_dist, total_min_dist); // 최소 거리 업데이트
        return;
    }

    for (int i = cur; i < chickens.size(); i++) { // 모든 조합 확인
        is_open[i] = true;
        choose_chickens(i + 1, count + 1);
        is_open[i] = false; // 백트래킹
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;


    for (int r = 0; r < n; r++)
        for (int c = 0; c < n; c++) { // 집과 치킨집 위치 저장
            int house;
            cin >> house;
            if (house == 1)
                houses.emplace_back(r, c);
            else if (house == 2)
                chickens.emplace_back(r, c);
        }

    // 타뷸레이션
    chinken_dists = vector<vector<int>>(houses.size(), vector<int>(chickens.size()));
    for (int i = 0; i < houses.size(); i++) // 각 집과 치킨집의 최소 거리 구하기
        for (int j = 0; j < chickens.size(); j++)
            chinken_dists[i][j] = abs(chickens[j].r - houses[i].r) + abs(chickens[j].c - houses[i].c);

    is_open = vector<char>(chickens.size(), false);

    choose_chickens(0, 0);
    cout << chicken_dist;
    return 0;
}