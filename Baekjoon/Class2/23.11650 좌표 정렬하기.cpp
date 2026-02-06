#include <iostream>
#include <utility>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    vector<pair<int, int>> coords(n);
    for (int i = 0; i < n; i++)
        cin >> coords[i].first >> coords[i].second;

    sort(coords.begin(), coords.end()); // pair은 first가 같으면 second 기준으로 정렬
    for (pair<int, int> coord : coords)
        cout << coord.first << ' ' << coord.second << '\n';
    return 0;
}