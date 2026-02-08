// 반복 동적 프로그래밍
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
constexpr int INF = 5001;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> bag_counts(n + 1, INF); // 타뷸레이션
    bag_counts[3] = 1;
    if (n >= 5) bag_counts[5] = 1;

    for (int i = 6; i <= n; i++)
        bag_counts[i] = min(bag_counts[i - 3], bag_counts[i - 5]) + 1; // 더 적은 봉지 수에 하나 추가

    if (bag_counts[n] >= INF) cout << -1;
    else cout << bag_counts[n];
    return 0;
}

/* 그리디
#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, bag_count = -1;
    cin >> n;

    for (int five_kg = n / 5; five_kg >= 0; five_kg--) { // 5kg 봉지 최대부터 0개까지
        int remain = n - (5 * five_kg);
        if (remain % 3 == 0) { // 나머지가 3으로 나눠 떨어지면 종료
            bag_count = five_kg + (remain / 3);
            break;
        }
    }
    cout << bag_count;
    return 0;
}
*/

/* 재귀 동적 프로그래밍
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
constexpr int INF = 5001;

int count_bags(int kg, vector<int>& bag_counts) {
    if (kg <= 5) return bag_counts[kg];
    if (bag_counts[kg] == INF) // 아직 계산 안 됨
        // 더 적은 봉지 수에 하나 추가
        bag_counts[kg] = min(count_bags(kg - 3, bag_counts), count_bags(kg - 5, bag_counts)) + 1;
    return bag_counts[kg];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> bag_counts(n + 1, INF); // 메모이제이션
    bag_counts[3] = 1;
    if (n >= 5) bag_counts[5] = 1;

    int bag_count = count_bags(n, bag_counts);
    if(bag_count >= INF) cout << -1;
    else cout << bag_count;
    return 0;
}
*/