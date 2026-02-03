#include <iostream>
using namespace std;
constexpr int NUM_RANGE = 10001;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, num;
    int num_counts[NUM_RANGE] = { 0 };
    cin >> n;
    for (int _ = 0; _ < n; _++) { // 계수 정렬
        cin >> num;
        num_counts[num]++;
    }
    for (int i = 1; i < NUM_RANGE; i++) // 출력
        for (int _ = 0; _ < num_counts[i]; _++)
            cout << i << '\n';
    return 0;
}