#include <iostream>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string input;

    for (int i = 0; i < 3; i++) {
        cin >> input;
        if (!isdigit(input[0])) continue; // 숫자인 입력 찾기
        int value = stoi(input);
        value += 3 - i; // 다음 숫자
        if (value % 15 == 0) cout << "FizzBuzz"; // 출력
        else if (value % 3 == 0) cout << "Fizz";
        else if (value % 5 == 0) cout << "Buzz";
        else cout << to_string(value);
        break;
    }
    return 0;
}