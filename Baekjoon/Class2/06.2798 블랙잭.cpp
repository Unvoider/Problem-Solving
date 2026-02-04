#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m, num, closest = 0;
    vector<int> nums;
    cin >> n >> m;
    for (int _ = 0; _ < n; _++) {
        cin >> num;
        nums.push_back(num);
    }

    for (int i = 0; i < n - 2; i++)
        for (int j = i + 1; j < n - 1; j++)
            for (int k = j + 1; k < n; k++) {
                int total = nums[i] + nums[j] + nums[k];
                if (total <= m && total > closest) {
                    closest = total;
                    if (closest == m) // 같으면 바로 종료
                        i = j = k = n;
                }
            }
    cout << closest;
    return 0;
}