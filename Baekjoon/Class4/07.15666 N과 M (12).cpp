#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;
vector<int> track;
vector<int> nums;

void back_track(int start) {
    if (track.size() == m) { // 출력
        for (int num : track)
            cout << num << ' ';
        cout << '\n';
        return;
    }
    for (int i = start; i < nums.size(); i++) {
        track.push_back(nums[i]); // 추가
        back_track(i);
        track.pop_back(); // 삭제
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;
    nums = vector<int>(n);
    for (int i = 0; i < n; i++)
        cin >> nums[i];
    sort(nums.begin(), nums.end()); // 정렬
    nums.erase(unique(nums.begin(), nums.end()), nums.end()); // 중복 제거
    back_track(0);
    return 0;
}