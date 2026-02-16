// 반복 동적 프로그래밍
#include <iostream>
using namespace std;
constexpr int FIB_MAX = 40;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    // 타뷸레이션
    int zero_count[FIB_MAX + 2] = { 1, 0 };
    for (int i = 2; i < FIB_MAX + 2; i++)
        zero_count[i] = zero_count[i - 1] + zero_count[i - 2];

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        cout << zero_count[n] << ' ' << zero_count[n + 1] << '\n';
    }
    return 0;
}

/* 재귀 동적 프로그래밍
#include <iostream>
using namespace std;
constexpr int FIB_MAX = 40;

// 메모이제이션
int zero_count[FIB_MAX + 2] = { 1, 0 };

void count_fib(int n) {
    if (n < 2) return;
    if (zero_count[n] != 0) return;
    count_fib(n - 1);
    count_fib(n - 2);
    zero_count[n] = zero_count[n - 1] + zero_count[n - 2];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        count_fib(n + 1);
        cout << zero_count[n] << ' ' << zero_count[n + 1] << '\n';
    }
    return 0;
}
*/