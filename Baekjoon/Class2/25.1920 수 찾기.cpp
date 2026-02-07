#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;

    cin >> n;
    vector<long long> n_vec(n);
    for (int i = 0; i < n; i++)
        cin >> n_vec[i];
    sort(n_vec.begin(), n_vec.end()); // 정렬

    cin >> m;
    for (int _ = 0; _ < m; _++) {
        long long m_num;
        cin >> m_num;
        // 이진 탐색 O(logn)
        cout << binary_search(n_vec.begin(), n_vec.end(), m_num) << '\n';
    }
    return 0;
}

/* 이진 탐색 구현
#include <iostream>
#include <vector>
#include <algorithm>
#define COMPARE(x, y) (x) < (y) ? -1 : (x) == (y) ? 0 : 1
using namespace std;

int bin_search(const vector<long long>& vec, long long num) {
    int left = 0, right = vec.size() - 1;
    while (left <= right) {
        int middle = (left + right) / 2;
        switch (COMPARE(vec[middle], num)) {
        case 0: return middle;
        case -1: left = middle + 1;
            break;
        case 1: right = middle - 1;
        }
    }
    return -1;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;

    cin >> n;
    vector<long long> n_vec(n);
    for (int i = 0; i < n; i++)
        cin >> n_vec[i];
    sort(n_vec.begin(), n_vec.end()); // 정렬

    cin >> m;
    for (int _ = 0; _ < m; _++) {
        long long m_num;
        cin >> m_num;
        // 이진 탐색 O(logn)
        if (bin_search(n_vec, m_num) > -1)
            cout << "1\n";
        else
            cout << "0\n";
    }
    return 0;
}
*/

/* unordered_set 사용
#include <iostream>
#include <unordered_set>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    unordered_set<long long> n_set;

    cin >> n;
    for (int i = 0; i < n; i++) {
        int n_num;
        cin >> n_num;
        n_set.insert(n_num);
    }

    cin >> m;
    for (int _ = 0; _ < m; _++) {
        long long m_num;
        cin >> m_num;
        // unordered_set은 해시 테이블을 사용하므로 find()에 대해 O(1)
        cout << (n_set.find(m_num) != n_set.end()) << '\n';
    }
    return 0;
}
*/