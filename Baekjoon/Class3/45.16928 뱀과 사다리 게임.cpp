#include <iostream>
#include <utility>
#include <queue>
using namespace std;
constexpr int BOARD_SIZE = 100;

int count_rolls(const int ladders_and_snakes[]) {
    int roll_counts[BOARD_SIZE + 1] = { 0 }; // 암시적 그래프
    queue<int> bfs;
    bfs.push(1); // 시작 위치
    while (!bfs.empty()) {
        int start = bfs.front();
        bfs.pop();
        for (int move = 1; move <= 6; move++) {
            int end = start + move;
            if (end < BOARD_SIZE && ladders_and_snakes[end] != 0) // 사다리 뱀 타기
                end = ladders_and_snakes[end];
            if (end <= 0 || end > BOARD_SIZE) // 경계 검사
                continue;
            if (roll_counts[end] == 0) { // 이동
                roll_counts[end] = roll_counts[start] + 1;
                if (end == 100)
                    return roll_counts[end];
                bfs.push(end);

            }
        }
    }
    return -1;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    int ladders_and_snakes[BOARD_SIZE] = { 0 };
    for (int i = 0; i < n + m; i++) {
        int start, end;
        cin >> start >> end;
        ladders_and_snakes[start] = end;
    }

    cout << count_rolls(ladders_and_snakes);
    return 0;
}