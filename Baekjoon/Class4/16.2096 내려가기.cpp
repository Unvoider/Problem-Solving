#include <iostream>
#include <algorithm>
using namespace std;
constexpr int TABLE_SIZE = 3;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    int max_table[TABLE_SIZE], prev_max_table[TABLE_SIZE];
    int min_table[TABLE_SIZE], prev_min_table[TABLE_SIZE];
    for (int i = 0; i < TABLE_SIZE; i++) { // 첫 열
        cin >> max_table[i];
        min_table[i] = max_table[i];
    }

    for (int i = 1; i < n; i++) {
        for (int j = 0; j < TABLE_SIZE; j++) {
            prev_max_table[j] = max_table[j]; // 슬라이딩 윈도우
            prev_min_table[j] = min_table[j];
            cin >> max_table[j]; // 다음 열
            min_table[j] = max_table[j];
        }
        max_table[0] += max(prev_max_table[0], prev_max_table[1]); // 최댓값 누적
        max_table[1] += *max_element(prev_max_table, prev_max_table + TABLE_SIZE);
        max_table[2] += max(prev_max_table[1], prev_max_table[2]);
        min_table[0] += min(prev_min_table[0], prev_min_table[1]); // 최솟값 누적
        min_table[1] += *min_element(prev_min_table, prev_min_table + TABLE_SIZE);
        min_table[2] += min(prev_min_table[1], prev_min_table[2]);
    }

    cout << *max_element(max_table, max_table + TABLE_SIZE) << ' ';
    cout << *min_element(min_table, min_table + TABLE_SIZE);
    return 0;
}