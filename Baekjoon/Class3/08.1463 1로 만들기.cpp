#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    // 타뷸레이션
    vector<int> count_table(n + 1);
    for (int i = 2; i <= n; i++) {
        int a, b, c;
        a = b = c = count_table[i - 1] + 1;
        if (i % 3 == 0) b = count_table[i / 3] + 1; // 3으로 나눠 떨어지면
        if (i % 2 == 0) c = count_table[i / 2] + 1; // 2로 나눠 떨어지면
        count_table[i] = min({ a, b, c });
    }
    cout << count_table[n];
    return 0;
}