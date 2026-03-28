#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> a(n);
    vector<int> max_lengths(n, 1);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        for (int j = 0; j < i; j++) // 각 도착점의 최대 길이 찾기
            if (a[i] > a[j])
                max_lengths[i] = max(max_lengths[i], max_lengths[j] + 1);
    }

    cout << *max_element(max_lengths.begin(), max_lengths.end());
    return 0;
}