#include <iostream>
#include <utility>
#include <vector>
#include <algorithm>
using namespace std;

bool asc_yx(pair<int, int> c1, pair<int, int> c2) {
    if (c1.second != c2.second)
        return c1.second < c2.second;
    else
        return c1.first < c2.first;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    vector<pair<int, int>> coords(n);
    for (int i = 0; i < n; i++)
        cin >> coords[i].first >> coords[i].second;

    sort(coords.begin(), coords.end(), asc_yx);
    for (pair<int, int> coord : coords)
        cout << coord.first << ' ' << coord.second << '\n';
    return 0;
}