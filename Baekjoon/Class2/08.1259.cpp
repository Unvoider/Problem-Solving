#include <iostream>
#include <string>
using namespace std;

bool is_palindrome(const string& str) {
    const size_t len = str.length();
    for (int i = 0; i < len / 2; i++) // 절반까지 비교
        if (str[i] != str[len - 1 - i])
            return false;
    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string str;
    while (cin >> str, str != "0") {
        if (is_palindrome(str)) cout << "yes" << '\n';
        else cout << "no" << '\n';
    }
    return 0;
}