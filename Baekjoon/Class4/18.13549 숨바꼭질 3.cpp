#include <iostream>
#include <vector>
#include <deque>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k;
    cin >> n >> k;
    int depth_limit = max(n, k) * 2;

    deque<int> dq; // 0-1 너비 우선 탐색
    vector<int> depths(depth_limit + 1, -1);
    dq.push_back(n); // 시작
    depths[n] = 0;

    while (!dq.empty()) {
        int start = dq.front();
        if (start == k) break;
        dq.pop_front();

        int end = start * 2;
        if (end <= depth_limit && depths[end] == -1) { // 순간 이동
            dq.push_front(end);
            depths[end] = depths[start];
        }

        for (int end : {start - 1, start + 1}) // 걷기
            if (end >= 0 && end <= depth_limit && depths[end] == -1) {
                dq.push_back(end);
                depths[end] = depths[start] + 1;
            }
    }

    cout << depths[k];
    return 0;
}