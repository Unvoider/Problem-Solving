#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> time_vec(n); // 인출하는 데 걸리는 시간
    for (int i = 0; i < n; i++)
        cin >> time_vec[i];
    sort(time_vec.begin(), time_vec.end()); // 정렬

    int min_total = 0; // 시간 합의 최솟값
    for (int i = 0; i < n; i++)
        min_total += time_vec[i] * (n - i);
    cout << min_total;
    return 0;
}