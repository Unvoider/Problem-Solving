#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    // 999999의 각 자리를 모두 더해도 기껏해야 54가 나오므로 N - 54부터 시작함
    for (int i = (n - 54 < 0 ? 0 : n - 54); i < n; i++) {
        int num = i, total = i;
        while (num) {
            total += num % 10; // 각 자리 수 더하기
            num /= 10;
        }
        if (total == n) { // 찾음
            cout << i;
            return 0;
        }
    }
    cout << 0; // 못 찾음
    return 0;
}