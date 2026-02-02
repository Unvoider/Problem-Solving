#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m = 0, score, total = 0;
    cin >> n;
    for (int _ = 0; _ < n; _++) {
        cin >> score;
        total += score;
        if (score > m)
            m = score;
    }
    cout << ((float)total / m * 100) / n;
    return 0;
}