#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    bool is_ascending = true, is_descending = true;
    int prev, cur;
    cin >> prev;
    for (int _ = 1; _ < 8; _++) {
        cin >> cur;
        if (prev >= cur) is_ascending = false;
        if (prev <= cur) is_descending = false;
        prev = cur;
    }
    if (is_ascending) cout << "ascending";
    else if (is_descending) cout << "descending";
    else cout << "mixed";
    return 0;
}

/*
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string input;
    getline(cin, input);
    if (!input.compare("1 2 3 4 5 6 7 8")) cout << "ascending";
    else if (!input.compare("8 7 6 5 4 3 2 1")) cout << "descending";
    else cout << "mixed";
}
*/