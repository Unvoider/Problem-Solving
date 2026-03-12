// priority_queue 사용
#include <iostream>
#include <queue>
#include <vector>
using namespace std;

void run_dual_priority_queue() {
    int k;
    cin >> k;

    // <num, index>
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> min_heap;
    priority_queue<pair<int, int>> max_heap;
    vector<char> visited(k);

    for (int i = 0; i < k; i++) {
        char operation;
        int num;
        cin >> operation >> num;

        switch (operation) {
        case 'I': // 삽입
            min_heap.push({ num, i });
            max_heap.push({ num, i });
            break;
        case 'D':
            if (num == -1) { // 최솟값 삭제
                while (!min_heap.empty()) {
                    if (visited[min_heap.top().second]) { // 방문했던 노드 삭제
                        min_heap.pop();
                        continue;
                    }
                    visited[min_heap.top().second] = true;
                    min_heap.pop();
                    break;
                }
            }
            else { // 최댓값 삭제
                while (!max_heap.empty()) {
                    if (visited[max_heap.top().second]) { // 방문했던 노드 삭제
                        max_heap.pop();
                        continue;
                    }
                    visited[max_heap.top().second] = true;
                    max_heap.pop();
                    break;
                }
            }
        }
    }
    while (!min_heap.empty() && visited[min_heap.top().second]) min_heap.pop();
    while (!max_heap.empty() && visited[max_heap.top().second]) max_heap.pop();

    if (min_heap.empty())
        cout << "EMPTY\n";
    else
        cout << max_heap.top().first << ' ' << min_heap.top().first << '\n'; // 최댓값 최솟값 출력
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--)
        run_dual_priority_queue();
    return 0;
}

/* multiset 사용
#include <iostream>
#include <set>
using namespace std;

void run_dual_priority_queue() {
    int k;
    cin >> k;

    multiset<int> q; // 이중 우선순위 큐

    while (k--) {
        char operation;
        int num;
        cin >> operation >> num;

        switch (operation) {
        case 'I': // 삽입
            q.insert(num);
            break;
        case 'D':
            if (q.empty())
                break;
            if (num == -1) // 최솟값 삭제
                q.erase(q.begin());
            else // 최댓값 삭제
                q.erase(--q.end());
        }
    }

    if (q.empty())
        cout << "EMPTY\n";
    else
        cout << *q.rbegin() << ' ' << *q.begin() << '\n'; // 최댓값 최솟값 출력
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--)
        run_dual_priority_queue();
    return 0;
}
*/