#include <iostream>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int damaged_idx, m, total = 0, weight = 1;
    string isbn;
    cin >> isbn;

    // total = (a+c+e+g+i+k) + 3(b+d+f+h+j+l)
    for (int i = 0; i < 13; i++) {
        if (isbn[i] == '*') // 손상 인덱스
            damaged_idx = i;
        else {
            int value = isbn[i] - '0';
            if (i == 12) // m 값
                m = value;
            else // 0~11번째 값 누적
                total += i % 2 == 0 ? value : 3 * value;
        }
    }

    // m = (10 - total % 10) % 10
    if (damaged_idx == 12) { // m 손상 시 바로 출력
        cout << (10 - total % 10) % 10;
        return 0;
    }
    if (damaged_idx % 2 == 1) // 홀수 번째 가중치
        weight = 3;
    for (int i = 0; i <= 9; i++) { // 0~9 넣어보고 맞으면 출력
        if (m == (10 - (total + i * weight) % 10) % 10) {
            cout << i;
            break;
        }
    }
    return 0;
}