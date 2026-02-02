#include <iostream>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t, r;
    string s, p;
    cin >> t;
    while (t--) {
        cin >> r >> s;
        p = "";
        for (int i = 0; i < s.size(); i++)
            for (int _ = 0; _ < r; _++)
                p += s[i];
        p += '\n';
        cout << p;
    }
    return 0;
}