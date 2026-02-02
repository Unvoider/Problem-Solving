#include <iostream>
using namespace std;

// 유클리트 호제법
int gcd(int a, int b) { // greatest common divisor
    int r = -1;
    while (r) {
        r = a % b;
        a = b;
        b = r;
    }
    return a;
}

int lcm(int a, int b) { // least common multiple
    return a * b / gcd(a, b);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int a, b;
    cin >> a >> b;
    cout << gcd(a, b) << '\n' << lcm(a, b);
    return 0;
}

/* 브루트 포스
#include <iostream>
#include <algorithm>
using namespace std;

int gcd(int a, int b) { // greatest common divisor
    for (int i = min(a, b); i > 1; i--)
        if (a % i == 0 && b % i == 0)
            return i;
    return 1;
}

int lcm(int a, int b) { // least common multiple
    for (int i = max(a, b); ; i++)
        if (i % a == 0 && i % b == 0)
            return i;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int a, b;
    cin >> a >> b;
    cout << gcd(a, b) << '\n' << lcm(a, b);
    return 0;
}
*/