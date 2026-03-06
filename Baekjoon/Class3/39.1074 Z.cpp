#include <iostream>
#include <cmath>
using namespace std;

int get_z_order(int size, int row, int col) {
    if (size == 2) // 종료 조건
        return row * 2 + col;

    int half = size >> 1;
    // half 제곱 * 사분면 Z 위치 + 재귀 호출
    return half * half * ((row < half ? 0 : 1) * 2 + (col < half ? 0 : 1))
        + get_z_order(half, row < half ? row : row - half, col < half ? col : col - half);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, r, c;
    cin >> n >> r >> c;
    cout << get_z_order(1 << n, r, c);
    return 0;
}