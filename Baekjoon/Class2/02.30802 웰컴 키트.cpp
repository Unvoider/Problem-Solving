#include <iostream>
#include <cmath>
using namespace std;
constexpr int T_SIZE_COUNT = 6;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, t = 0, p, p_rest;
    int t_counts[T_SIZE_COUNT];
    int t_bundle, p_bundle;

    cin >> n;
    for (int i = 0; i < T_SIZE_COUNT; i++)
        cin >> t_counts[i];
    cin >> t_bundle >> p_bundle;

    // 티셔츠 묶음
    for (int i = 0; i < T_SIZE_COUNT; i++)
        t += int(ceil(t_counts[i] / (double)t_bundle));
        // t += (t_counts[i] + t_bundle - 1) / t_bundle;

    // 펜 묶음과 낱개
    p = n / p_bundle;
    p_rest = n % p_bundle;

    cout << t << '\n' << p << ' ' << p_rest;
    return 0;
}