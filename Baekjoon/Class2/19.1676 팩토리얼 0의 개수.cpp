#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, five_count = 0;
    cin >> n;

    // 곱해진 10(2 * 5의 쌍) 개수 세기
    // 소인수분해 시 항상 2보다 5가 적으므로 5의 개수만 세면 됨
    for (int i = 5; i <= n; i *= 5)
        five_count += n / i;
    cout << five_count;
    return 0;
}