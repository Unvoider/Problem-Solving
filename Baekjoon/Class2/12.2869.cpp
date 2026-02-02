#include <iostream>
using namespace std;

long long div_ceil(long long x, long long y) {
    return (x + y - 1) / y;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long a, b, v;
    cin >> a >> b >> v;
    // 첫 상승을 제외한 거리: v - a
    // 매일 상승 거리: a - b
    cout << div_ceil(v - a, a - b) + 1;
    // 위의 전개식:
    // cout << (v - b - 1) / (a - b) + 1;
    return 0;
}