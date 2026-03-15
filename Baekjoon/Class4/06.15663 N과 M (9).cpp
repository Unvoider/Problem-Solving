#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;
vector<char> visited;
vector<int> track;
vector<int> nums;

void back_track() {
    if (track.size() == m) { // 출력
        for (int num : track)
            cout << num << ' ';
        cout << '\n';
        return;
    }
    int prev_num = -1;
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            if (prev_num == nums[i]) continue; // 해당 깊이 직전 숫자와 같으면 건너뛰기
            else prev_num = nums[i];
            track.push_back(nums[i]); // 추가
            visited[i] = true;
            back_track();
            track.pop_back(); // 삭제
            visited[i] = false;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;
    visited = vector<char>(n);
    nums = vector<int>(n);
    for (int i = 0; i < n; i++)
        cin >> nums[i];
    sort(nums.begin(), nums.end()); // 정렬
    back_track();
    return 0;
}