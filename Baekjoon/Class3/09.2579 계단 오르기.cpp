#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int steps_n;
    cin >> steps_n;

    vector<int> steps(steps_n + 1);
    for (int i = 1; i <= steps_n; i++)
        cin >> steps[i];

    vector<int> max_scores(steps_n + 1); // 타뷸레이션
    if (steps_n >= 1) max_scores[1] = steps[1];
    if (steps_n >= 2) max_scores[2] = steps[1] + steps[2];
    for (int i = 3; i <= steps_n; i++) {
        int leap_before = steps[i] + max_scores[i - 2];
        int no_leap_before = steps[i] + steps[i - 1] + max_scores[i - 3];
        max_scores[i] = max(leap_before, no_leap_before);
    }
    cout << max_scores[steps_n];
    return 0;
}