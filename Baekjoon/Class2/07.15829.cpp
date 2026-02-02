#include <iostream>
#include <string>
using namespace std;
constexpr int CHAR_START = 'a' - 1;
constexpr long long R = 31LL, M = 1234567891LL;

long long get_hash(const string& str, int len) {
    long long hash = 0, power = 1LL;
    for (int i = 0; i < len; i++) {
        // 오버플로우를 방지하기 위해 hash와 power에 나머지 연산
        hash = (hash + (str[i] - CHAR_START) * power) % M;
        power = power * R % M;
    }
    return hash;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int l;
    string str;
    cin >> l >> str;
    cout << get_hash(str, l);
    return 0;
}