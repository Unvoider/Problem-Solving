#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    vector<int> sides(3);
    int a, b, c;
    while (true) {

        cin >> a >> b >> c;
        if (a == 0 && b == 0 && c == 0)
            break;
        sides = { a, b, c };
        sort(sides.begin(), sides.end());
        if (sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2])
            cout << "right" << '\n';
        else cout << "wrong" << '\n';
    }
    return 0;
}

/* biggest 찾기
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int a, b, c, biggest;
    while (true) {
        cin >> a >> b >> c;
        if (a == 0 && b == 0 && c == 0)
            break;
        biggest = max({ a, b, c });
        if (biggest * biggest * 2 == a * a + b * b + c * c)
            cout << "right" << '\n';
        else cout << "wrong" << '\n';
    }
    return 0;
}
*/

/* 모든 경우 확인
#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int a, b, c;
    while (true) {
        cin >> a >> b >> c;
        if (a == 0 && b == 0 && c == 0)
            break;
        if (a * a + b * b == c * c
            || b * b + c * c == a * a
            || c * c + a * a == b * b)
            cout << "right" << '\n';
        else cout << "wrong" << '\n';
    }
    return 0;
}
*/