#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool is_length_enough(int cutter_height, int required, const vector<int>& trees) {
    long long length = 0;
    for (int tree : trees)
        if (tree > cutter_height) {
            length += tree - cutter_height;
            if (length >= required) return true; // 충분한 길이
        }
    return false; // 충분하지 않음
}

int max_cutter_height(int required, const vector<int>& trees) {
    int answer = 0;
    int left = 0, right = *max_element(trees.begin(), trees.end());
    while (left <= right) {
        int middle = left + ((right - left) / 2);
        if (is_length_enough(middle, required, trees)) { // 더 높게 자를 수도 있음
            left = middle + 1;
            answer = middle;
        }
        else // 더 낮게 잘라야 함
            right = middle - 1;
    }
    return answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<int> trees(n);
    for (int i = 0; i < n; i++)
        cin >> trees[i];

    cout << max_cutter_height(m, trees);
    return 0;
}