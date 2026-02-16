#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k;
    cin >> n >> k;

    vector<int> coins(n); // 동전 종류
    for (int i = n - 1; i >= 0; i--)
        cin >> coins[i];

    int coin_count = 0; // 동전 개수
    for (const int coin : coins) {
        if (k == 0) break;
        coin_count += k / coin;
        k %= coin;
    }
    cout << coin_count;
    return 0;
}