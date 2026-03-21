#include <iostream>
#include <vector>
#include <array>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        array<vector<int>, 2> scores = { vector<int>(n), vector<int>(n) };
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < n; j++)
                cin >> scores[i][j];

        if (n != 1) {
            scores[0][1] += scores[1][0]; // 위 뗌
            scores[1][1] += scores[0][0]; // 아래 뗌
            for (int i = 2; i < n; i++) {
                scores[0][i] += max(scores[1][i - 1], scores[1][i - 2]); // 위 뗌
                scores[1][i] += max(scores[0][i - 1], scores[0][i - 2]); // 아래 뗌
            }
        }

        cout << max(scores[0][n - 1], scores[1][n - 1]) << '\n';
    }
    return 0;
}