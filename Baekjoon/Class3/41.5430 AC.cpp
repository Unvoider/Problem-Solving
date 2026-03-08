#include <iostream>
#include <string>
#include <deque>
using namespace std;

void ac() {
    string p, xn_str;
    int _;
    cin >> p >> _ >> xn_str;

    int x = 0;
    deque<int> xn;
    for (char ch : xn_str) { // 파싱
        if (isdigit(ch))
            x = x * 10 + (ch - '0');
        else if (ch == ',') {
            xn.push_back(x);
            x = 0;
        }
    }
    if (x != 0) xn.push_back(x);

    bool is_front = true; // 포인터 위치
    for (char command : p)
        if (command == 'R') // 덱 뒤집기
            is_front = !is_front;
        else { // 팝
            if (xn.empty()) { // 비었음
                cout << "error\n";
                return;
            }
            if (is_front)
                xn.pop_front();
            else
                xn.pop_back();
        }

    cout << '['; // 출력
    if (!xn.empty())
        if (is_front) {
            deque<int>::iterator it = xn.begin();
            cout << *it;
            for (++it; it != xn.end(); ++it) cout << ',' << *it;
        }
        else {
            deque<int>::reverse_iterator it = xn.rbegin();
            cout << *it;
            for (++it; it != xn.rend(); ++it) cout << ',' << *it;
        }
    cout << "]\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--)
        ac();

    return 0;
}