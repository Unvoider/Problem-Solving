#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, title = 665;
    cin >> n;

    for (int _ = 0; _ < n; _++) {
        bool found = false;
        while (!found) {
            title++;
            int dividend = title, six_count = 0;
            while (dividend) {
                if (dividend % 10 == 6) { // 6이 세 번 연속되는 수 찾기
                    six_count++;
                    if (six_count == 3)
                        found = true;
                }
                else
                    six_count = 0;
                dividend /= 10;
            }
        }
    }
    cout << title;
    return 0;
}

/* 문자열 이용
#include <iostream>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, count = 1, title = 665;
    cin >> n;

    while (count <= n) {
        title++;
        if (to_string(title).find("666") != string::npos)
            count++;
    }
    cout << title;
    return 0;
}
*/