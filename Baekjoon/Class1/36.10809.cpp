#include <iostream>
#include <string>
#include <vector>
using namespace std;
constexpr int CHAR_RANGE = 26;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    vector<int> first_appearance(CHAR_RANGE, -1);
    string s;
    cin >> s;
    for (int i = 0; i < s.length(); i++) {
        int index = s[i] - 'a';
        if (first_appearance[index] == -1)
            first_appearance[index] = i;
    }
    for (int i = 0; i < CHAR_RANGE; i++)
        cout << first_appearance[i] << ' ';
    return 0;
}