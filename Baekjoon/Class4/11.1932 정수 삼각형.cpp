#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<vector<int>> triangle(n); // 삼각형 입력
    for (int i = 0; i < n; i++) {
        triangle[i].resize(i + 1);
        for (int j = 0; j <= i; j++)
            cin >> triangle[i][j];
    }


    for (int i = n - 1; i > 0; i--) // 맨아래 레벨부터 더 큰 자식 누적하기
        for (int j = 0; j < i; j++)
            triangle[i - 1][j] += max(triangle[i][j], triangle[i][j + 1]);

    cout << triangle[0][0];
    return 0;
}