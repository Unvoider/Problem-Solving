#include <iostream>
#include <vector>
#include <array>
using namespace std;
constexpr char EMPTY = '0';

/*
가로 도착
000 000
000 000
pp0 0pp

000 000
p00 000
0p0 0pp

세로 도착
00p 000
00p 00p
000 00p

0p0 000
00p 00p
000 00p

대각선 도착
000 000
pp0 0p0
000 00p

0p0 000
0p0 0p0
000 00p

p00 000
0p0 0p0
000 00p
*/

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<vector<char>> walls(n + 1, vector<char>(n + 1)); // 벽 위치 기록
    for (int r = 1; r <= n; r++)
        for (int c = 1; c <= n; c++)
            cin >> walls[r][c];

    // <행, 열, 파이프 방향(가로: 0, 세로: 1, 대각선: 2)> 
    vector<vector<array<int, 3>>> moves(n + 1, vector<array<int, 3>>(n + 1));
    moves[1][2][0] = 1;

    for (int c = 3; c <= n; c++) // 첫 줄
        if (walls[1][c] == EMPTY)
            moves[1][c][0] = moves[1][c - 1][0]; // 가로 도착

    for (int r = 2; r <= n; r++) // 나머지 줄
        for (int c = 2; c <= n; c++)
            if (walls[r][c] == EMPTY) {
                moves[r][c][0] = moves[r][c - 1][0] + moves[r][c - 1][2]; // 가로 도착
                moves[r][c][1] = moves[r - 1][c][1] + moves[r - 1][c][2]; // 세로 도착
                if (walls[r - 1][c] == EMPTY && walls[r][c - 1] == EMPTY) // 대각선 도착
                    moves[r][c][2] = moves[r - 1][c - 1][0] + moves[r - 1][c - 1][1] + moves[r - 1][c - 1][2];
            }

    cout << moves[n][n][0] + moves[n][n][1] + moves[n][n][2];
    return 0;
}