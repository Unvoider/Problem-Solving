#include <iostream>
#include <string>
#include <stack>
using namespace std;

bool balanced_world(const string& str) {
    stack<char> brackets;
    for (char ch : str)
        if (ch == '(' || ch == '[') // 왼쪽 괄호 push
            brackets.push(ch);
        else if (ch == ')' || ch == ']') { // 오른쪽 괄호 pop
            if (brackets.empty()) return false; // 스택 빔
            char top = brackets.top();
            if (top != '(' && ch == ')') // 괄호 짝 안 맞음
                return false;
            if (top != '[' && ch == ']')
                return false;
            brackets.pop();
        }
    return brackets.empty(); // 남은 괄호 없으면 성공
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string str;
    while (getline(cin, str) && str != ".")
        if (balanced_world(str)) cout << "yes\n";
        else cout << "no\n";
    return 0;
}