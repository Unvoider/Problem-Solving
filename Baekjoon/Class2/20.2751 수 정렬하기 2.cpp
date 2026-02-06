#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, num;
    vector<int> nums;
    cin >> n;
    nums.reserve(n);
    while (n--) {
        cin >> num;
        nums.push_back(num);
    }
    sort(nums.begin(), nums.end());
    for (int num : nums)
        cout << num << '\n';
    return 0;
}