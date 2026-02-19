#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

bool is_square(int n) { // 제곱수인지 확인
    int root = int(sqrt(n));
    return root * root == n;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    int power_max = int(sqrt(n));

    vector<int> powers(power_max + 1); // 타뷸레이션
    for (int i = 1; i <= power_max; i++)
        powers[i] = i * i;

    if (powers[power_max] == n) { // 1개
        cout << 1;
        return 0;
    }

    for (int i = 1; i <= power_max; i++) { // 2개
        int remainder = n - powers[i];
        if (remainder < 1)
            break;
        if (is_square(remainder)) {
            cout << 2;
            return 0;
        }
    }

    for (int i = 1; i <= power_max; i++) // 3개
        for (int j = 1; j <= i; j++) {
            int remainder = n - powers[i] - powers[j];
            if (remainder < 1)
                break;
            if (is_square(remainder)) {
                cout << 3;
                return 0;
            }
        }

    cout << 4; // 4개
    return 0;
}