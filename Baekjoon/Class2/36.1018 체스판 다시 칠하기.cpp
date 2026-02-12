#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

// 나머지 연산
int count_paint(const vector<string>& board, int row, int col) { // 색칠해야 하는 칸 세기
    int count = 0;
    for (int i = row; i < row + 8; i++)
        for (int j = col; j < col + 8; j++)
            if ((i + j) % 2 == 0 && board[i][j] == 'B') // 잘못 색칠된 검정
                count++;
            else if ((i + j) % 2 == 1 && board[i][j] == 'W') // 잘못 색칠된 하양
                count++;
    return count;
}

/* 체스판 생성
int count_paint(const vector<string>& board, int row, int col) { // 색칠해야 하는 칸 세기
    char row_first = 'W'; // 흰색으로 시작하는 체스 보드
    int count = 0;
    for (int i = 0; i < 8; i++) {
        char cur = row_first;
        for (int j = 0; j < 8; j++) {
            if (board[i + row][j + col] != cur)
                count++;
            cur = (cur == 'W') ? 'B' : 'W';
        }
        row_first = (row_first == 'W') ? 'B' : 'W';
    }
    return count;
}
*/

/* 체스판 정의
const string CHESS_BOARD[8] = { // 흰색으로 시작하는 체스 보드
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW"
};
int count_paint(const vector<string>& board, int row, int col) { // 색칠해야 하는 칸 세기
    int count = 0;
    for (int i = 0; i < 8; i++)
        for (int j = 0; j < 8; j++)
            if (board[i + row][j + col] != CHESS_BOARD[i][j])
                count++;
    return count;
}
*/

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m, min_count = 64;
    cin >> n >> m;
    vector<string> board(n);
    for (int i = 0; i < n; i++)
        cin >> board[i];

    for (int row = 0; row <= n - 8; row++)
        for (int col = 0; col <= m - 8; col++) {
            int count = count_paint(board, row, col);
            // 흰색으로 시작할 때 색칠할 칸, 반전한 경우, 이전 최소값 중 최소값 선택
            min_count = min({ count, 64 - count, min_count });
        }
    cout << min_count;
    return 0;
}