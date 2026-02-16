#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    unordered_map<string, string> passwords; // <site, password>
    passwords.reserve(n);
    while (n--) { // 비밀번호 입력
        string site, password;
        cin >> site >> password;
        passwords.emplace(site, password);
    }
    while (m--) { // 비밀번호 출력
        string site;
        cin >> site;
        cout << passwords[site] << '\n';
    }
    return 0;
}