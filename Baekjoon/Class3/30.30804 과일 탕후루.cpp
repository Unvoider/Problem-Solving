#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> sn(n); // 과일 순서
    for (int i = 0; i < n; i++)
        cin >> sn[i];

    int max_fruit = 0;
    int fruit_types = 0; // 과일 종류
    int fruit_counts[10] = {}; // 과일 종류별 개수

    int front = 0, rear = 0;
    while (rear < n) {
        int rear_fruit = sn[rear++]; // 과일 추가
        if (fruit_counts[rear_fruit]++ == 0)
            fruit_types++;
        while (fruit_types > 2) { // 두 종류보다 많으면 과일 제거
            int front_fruit = sn[front++];
            if (--fruit_counts[front_fruit] == 0)
                fruit_types--;
        }
        max_fruit = max(max_fruit, rear - front); // 최대 개수 업데이트
    }
    cout << max_fruit;
    return 0;
}