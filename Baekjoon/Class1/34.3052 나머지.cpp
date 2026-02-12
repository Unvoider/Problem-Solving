// 카운팅
#include <iostream>
#include <array>
#include <algorithm>
using namespace std;
constexpr int INPUT_COUNT = 10;
constexpr int DIVISOR = 42;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int num;
    array<bool, DIVISOR> has_nums = { false };

    for (int _ = 0; _ < INPUT_COUNT; _++) {
        cin >> num;
        has_nums[num % DIVISOR] = true;
    }
    cout << count(has_nums.begin(), has_nums.end(), true); // 서로 다른 나머지 세기
    return 0;
}

/* unordered_set 사용
#include <iostream>
#include <unordered_set>
using namespace std;
constexpr int INPUT_COUNT = 10;
constexpr int DIVISOR = 42;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    unordered_set<int> num_set;
    int num;

    for (int _ = 0; _ < INPUT_COUNT; _++) {
        cin >> num;
        num_set.insert(num % DIVISOR);
    }

    cout << num_set.size();
    return 0;
}
*/

/* 브루트포스
#include <iostream>
#include <array>
using namespace std;
constexpr int INPUT_COUNT = 10;
constexpr int DIVISOR = 42;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    array<int, INPUT_COUNT> nums = {-1};
    int num, cursor = 0;
    bool has_num;

    // 배열 nums[0:cursor - 1]과 입력값 num을 비교
    // 중복되지 않으면 배열에 추가
    for (int _ = 0; _ < INPUT_COUNT; _++) {
        cin >> num;
        num %= DIVISOR;
        has_num = false;
        for (int i = 0; i < cursor; i++)
            if (nums[i] == num)
                has_num = true;
        if (!has_num)
            nums[cursor++] = num;
    }

    cout << cursor;
    return 0;
}
*/