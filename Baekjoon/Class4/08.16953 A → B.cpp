#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int a, b;
    cin >> a >> b;

    int depth = 1;
    while (b > a) {
        if (b % 2 == 0) // 2를 곱한다
            b >>= 1;
        else if (b % 10 == 1) // 1을 수의 가장 오른쪽에 추가한다
            b /= 10;
        else // 미리 종료
            break;
        depth++;
    }
    cout << (a == b ? depth : -1);
    return 0;
}