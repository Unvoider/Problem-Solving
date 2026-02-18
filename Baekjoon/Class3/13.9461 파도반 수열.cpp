#include <iostream>
using namespace std;
constexpr int MAX_NUM = 100;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long padovan[MAX_NUM + 1]; // 타뷸레이션
    padovan[1] = padovan[2] = padovan[3] = 1;
    padovan[4] = padovan[5] = 2;
    for (int i = 6; i <= MAX_NUM; i++)
        padovan[i] = padovan[i - 5] + padovan[i - 1];

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        cout << padovan[n] << '\n';
    }
    return 0;
}