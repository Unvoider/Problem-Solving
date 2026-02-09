#include <iostream>
#include <string>
using namespace std;

bool vps(const string& ps) { // valid parenthesis string
    int count = 0;
    for (char ch : ps)
        if (ch == '(') // 왼쪽 괄호 count++
            count++;
        else // 오른쪽 괄호 count--
            if (!count) return false; // count 빔
            else count--;
    return !count; // 남은 괄호 없으면 성공
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    string ps;
    cin >> t;
    while (t-- && cin >> ps)
        if (vps(ps)) cout << "YES\n";
        else cout << "NO\n";
    return 0;
}