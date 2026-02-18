#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<long long> sums(n + 1);
    for (int i = 1; i <= n; i++) {
        int num;
        cin >> num;
        sums[i] = sums[i - 1] + num;
    }

    while (m--) {
        int i, j;
        cin >> i >> j;
        cout << sums[j] - sums[i - 1] << '\n';
    }
    return 0;
}