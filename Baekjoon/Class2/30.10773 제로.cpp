#include <iostream>
#include <stack>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int k, num;
    long long total = 0;
    stack<int> nums;

    cin >> k;
    while (k--) {
        cin >> num;
        if (num == 0) nums.pop(); // 0이면 pop
        else nums.push(num);
    }
    while (!nums.empty()) {
        total += nums.top();
        nums.pop();
    }
    cout << total;
    return 0;
}