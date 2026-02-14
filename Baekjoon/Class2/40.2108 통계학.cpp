#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, total = 0;
    cin >> n;

    vector<int> nums(n);
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        nums[i] = num;
        total += num; // 합계
    }

    sort(nums.begin(), nums.end()); // 정렬

    // 두 번째로 작은 최빈값 찾기
    int prev = nums[0], mode = nums[0], freq = 1, max_freq = 1, mode_count = 1;
    for (int i = 1; i < n; i++) {
        // 빈도 계산
        if (prev == nums[i])
            freq++;
        else
            freq = 1;

        // 최대 빈도 찾기
        if (freq == max_freq) { // 최대 빈도와 같은 빈도
            if (mode_count < 2) { // 두 번째까지 업데이트
                mode_count++;
                mode = nums[i];
            }
        }
        else if (freq > max_freq) { // 최대 빈도보다 높은 빈도
            mode_count = 1;
            max_freq = freq;
            mode = nums[i];
        }

        prev = nums[i];
    }

    cout << round(total / double(n)) + 0 << '\n'; // 산술평균
    cout << nums[n / 2] << '\n'; // 중앙값
    cout << mode << '\n'; // 최빈값
    cout << nums[n - 1] - nums[0] << '\n'; // 범위
    return 0;
}