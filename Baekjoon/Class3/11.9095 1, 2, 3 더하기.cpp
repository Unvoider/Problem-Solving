#include <iostream>
using namespace std;
constexpr int MAX_NUM = 10;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int sum_counts[MAX_NUM + 1]; // 타뷸레이션
    sum_counts[1] = 1; // 1
    sum_counts[2] = 2; // 1 + 1, 2
    sum_counts[3] = 4; // 1 + 1 + 1, 1 + 2, 2 + 1, 3
    for (int i = 4; i <= MAX_NUM; i++)
        sum_counts[i] = sum_counts[i - 3] + sum_counts[i - 2] + sum_counts[i - 1];

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        cout << sum_counts[n] << '\n';
    }
    return 0;
}