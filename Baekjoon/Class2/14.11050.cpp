#include <iostream>
using namespace std;

int binomial_coefficient(int n, int k) {
    int result = 1;
    if (k > n / 2) // k가 n의 절반보다 크면 n - k로 교체
        k = n - k;
    for (int i = 1; i <= k; i++) {
        result *= n + 1 - i;
        result /= i;
    }
    return result;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k;
    cin >> n >> k;
    cout << binomial_coefficient(n, k);
    return 0;
}