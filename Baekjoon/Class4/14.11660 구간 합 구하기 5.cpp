#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> board(n + 1, vector<int>(n + 1));
    for (int i = 1; i <= n; i++) // 누적 합
        for (int j = 1; j <= n; j++) {
            cin >> board[i][j];
            board[i][j] += board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
        }

    while (m--) { // 출력
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        cout << board[x2][y2] + board[x1 - 1][y1 - 1] - board[x2][y1 - 1] - board[x1 - 1][y2] << '\n';
    }
    return 0;
}