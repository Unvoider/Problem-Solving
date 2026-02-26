// 이진 탐색
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> xn(n);
    for (int i = 0; i < n; i++)
        cin >> xn[i];

    vector<int> sorted_xn = xn;
    sort(sorted_xn.begin(), sorted_xn.end()); // 정렬
    sorted_xn.erase(unique(sorted_xn.begin(), sorted_xn.end()), sorted_xn.end()); // 중복 제거

    for (int x : xn) // 이진 탐색으로 위치 찾기
        cout << lower_bound(sorted_xn.begin(), sorted_xn.end(), x) - sorted_xn.begin() << ' ';
    return 0;
}

/* 순서 인덱스 운영
#include <iostream>
#include <utility>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<pair<int, int>> xn(n); // <인덱스, 값>
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        xn[i] = { i, x };
    }

    // 값 기준 정렬
    sort(xn.begin(), xn.end(), [](const auto& a, const auto& b) {
        return a.second < b.second;
    });

    // 압축
    int prev = xn[0].second;
    int order = 0;
    vector<int> compression(n);
    for (int i = 0; i < n; i++) {
        int x = xn[i].second;
        if (prev != x) { // 값이 이전과 다르면 순서 증가
            prev = x;
            order++;
        }
        compression[xn[i].first] = order;
    }

    for (int i = 0; i < n; i++)
        cout << compression[i] << ' ';
    return 0;
}
*/

/* unordered_map 사용
#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> xn(n);
    for (int i = 0; i < n; i++)
        cin >> xn[i];

    vector<int> sorted_xn = xn;
    sort(sorted_xn.begin(), sorted_xn.end()); // 정렬
    sorted_xn.erase(unique(sorted_xn.begin(), sorted_xn.end()), sorted_xn.end()); // 중복 제거

    unordered_map<int, int> compression; // unordered_map으로 순서 저장
    for (int i = 0; i < sorted_xn.size(); i++)
        compression[sorted_xn[i]] = i;

    for (int x : xn)
        cout << compression[x] << ' ';
    return 0;
}
*/