// 이진 탐색
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n;
    vector<int> cards(n);
    for (int i = 0; i < n; i++)
        cin >> cards[i];
    sort(cards.begin(), cards.end()); // 정렬

    cin >> m;
    while (m--) {
        int target;
        cin >> target;
        // 시작과 끝 인덱스 이진 탐색 O(logn)
        auto target_range = equal_range(cards.begin(), cards.end(), target);
        cout << target_range.second - target_range.first << ' ';
        // auto target_lb = lower_bound(cards.begin(), cards.end(), target);
        // auto target_ub = upper_bound(cards.begin(), cards.end(), target);
        // cout << distance(target_lb, target_ub) << ' ';
    }
    return 0;
}

/* 이진 탐색 구현
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int bin_search_lower_bound(const vector<int>& vec, int target) {
    int lower_bound = -1;
    int left = 0, right = vec.size() - 1;
    while (left <= right) {
        int middle = (left + right) / 2;
        if (vec[middle] >= target) {
            if (vec[middle] == target) // 찾음
                lower_bound = middle;
            right = middle - 1; // 찾았어도 왼쪽 범위 계속 확인
        }
        else
            left = middle + 1;
    }
    return lower_bound;
}

int bin_search_upper_bound(const vector<int>& vec, int target) {
    int upper_bound = -1;
    int left = 0, right = vec.size() - 1;
    while (left <= right) {
        int middle = (left + right) / 2;
        if (vec[middle] <= target) {
            if (vec[middle] == target) // 찾음
                upper_bound = middle + 1;
            left = middle + 1; // 찾았어도 오른쪽 범위 계속 확인
        }
        else
            right = middle - 1;
    }
    return upper_bound;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;

    cin >> n;
    vector<int> cards(n);
    for (int i = 0; i < n; i++)
        cin >> cards[i];
    sort(cards.begin(), cards.end()); // 정렬

    cin >> m;
    for (int _ = 0; _ < m; _++) {
        int target;
        cin >> target;
        // 시작과 끝 인덱스 이진 탐색 O(logn)
        int target_lb = bin_search_lower_bound(cards, target);
        if (target_lb == -1) { // 시작 인덱스 없음
            cout << "0 ";
            continue;
        }
        int target_ub = bin_search_upper_bound(cards, target);
        cout << target_ub - target_lb << ' ';
    }
    return 0;
}
*/

/* unordered_map 사용
#include <iostream>
#include <unordered_map>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    unordered_map<int, int> cards(n);

    cin >> n;
    for (int i = 0; i < n; i++) {
        int card;
        cin >> card;
        cards[card]++;
    }

    cin >> m;
    while (m--) {
        int target;
        cin >> target;
        // unordered_map의 접근 시간 O(1)
        cout << cards[target] << ' ';
    }
    return 0;
}
*/