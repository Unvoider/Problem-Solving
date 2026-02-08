// 반복 동적 프로그래밍
#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t, k, n;
    int apt[15][15] = { 0 }; // 타뷸레이션

    for (int i = 0; i < 15; i++) {
        apt[0][i] = i + 1; // 0층 초기화
        apt[i][0] = 1; // 1호 초기화
    }
    for (int i = 1; i < 15; i++) // 전체 계산
        for (int j = 1; j < 15; j++)
            apt[i][j] = apt[i - 1][j] + apt[i][j - 1]; // 아랫집 + 왼쪽 집

    cin >> t;
    while (t--) {
        cin >> k >> n;
        cout << apt[k][n - 1] << '\n';
    }
    return 0;
}

/* 재귀 동적 프로그래밍
int apt[15][15] = { 0 }; // 메모이제이션

int count_people(int floor, int room) {
    // 0층/1호 고정 값
    if (floor == 0) return room;
    if (room == 1) return 1;

    // 저장된 값 반환
    int count = apt[floor][room];
    if (count) return count;

    // 없으면 계산
    count = count_people(floor - 1, room) + count_people(floor, room - 1);
    apt[floor][room] = count;
    return count;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t, k, n;

    for (int i = 0; i < 15; i++) {
        apt[0][i] = i + 1; // 0층 초기화
        apt[i][0] = 1; // 1호 초기화
    }

    cin >> t;
    while (t--) {
        cin >> k >> n;
        cout << count_people(k, n) << '\n';
    }
    return 0;
}
*/