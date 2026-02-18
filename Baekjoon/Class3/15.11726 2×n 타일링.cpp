#include <iostream>
#include <vector>
using namespace std;
constexpr int DIVISOR = 10007;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> tiling_cases(n + 1); // 타뷸레이션
    if (n >= 1) tiling_cases[1] = 1;
    if (n >= 2) tiling_cases[2] = 2;
    for (int i = 3; i <= n; i++)
        tiling_cases[i] = (tiling_cases[i - 2] + tiling_cases[i - 1]) % DIVISOR;

    cout << tiling_cases[n];
    return 0;
}