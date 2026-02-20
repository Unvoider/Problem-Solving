#include <iostream>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string expr;
    cin >> expr;
    expr += '+'; // 종료 조건

    int total = 0, start = 0, end = 0, sign = 1;
    while (end < expr.size()) { // '-'가 나오기 전까지 더하기
        char token = expr[end];
        if (token == '+' || token == '-') {
            total += sign * stoi(expr.substr(start, end - start));
            start = end + 1;
            end += 2;
            if (token == '-') sign = -1; // '-'가 나오면 빼기
        }
        else end++;
    }
    cout << total;
    return 0;
}