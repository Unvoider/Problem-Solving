#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    if (n == 0) {
        cout << '0';
        return 0;
    }

    vector<int> opinions(n);
    for (int i = 0; i < n; i++)
        cin >> opinions[i];
    sort(opinions.begin(), opinions.end()); // 정렬

    int total = 0;
    int exclusion = int(round(n * 0.15)); // 절사 범위
    for (int i = exclusion; i < n - exclusion; i++) // 절사
        total += opinions[i];
    cout << round(double(total) / (n - 2 * exclusion)); // 평균
    return 0;
}