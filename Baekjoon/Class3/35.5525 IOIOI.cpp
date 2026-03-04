#include <iostream>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    string s;
    cin >> n >> m >> s;

    int p_count = 0;
    for (int i = 0; i < m - n * 2; i++)
        if (s[i] == 'I') { // 시작 문자 찾기
            int oi_count = 0;
            while (i + 2 < m) { // 뒤에 있는 문자 두 개 확인
                if (s[i + 1] == 'O' && s[i + 2] == 'I') {
                    i += 2;
                    oi_count++;
                    if (oi_count >= n) p_count++;
                }
                else
                    break;
            }
        }

    cout << p_count;
    return 0;
}