#include <iostream>
#include <queue>
#include <utility>
#include <cmath>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    // 최소 힙
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
    while (n--) {
        int x;
        cin >> x;
        if (x == 0) // 팝
            if (q.empty()) // 빔
                cout << '0' << '\n';
            else {
                cout << q.top().second << '\n';
                q.pop();
            }
        else // 푸시
            q.push({ abs(x), x });
    }
    return 0;
}