#include <iostream>
#include <utility>
#include <queue>
using namespace std;

void run_printer() {
    int n, m;
    cin >> n >> m;
    priority_queue<int> priorities; // 우선순위 max heap
    queue<pair<int, int>> printer_queue; // <인덱스, 우선순위>

    for (int i = 0; i < n; i++) { // 초기화
        int priority;
        cin >> priority;
        priorities.push(priority);
        printer_queue.push({ i, priority });
    }

    // 우선순위가 높은 것부터 출력
    int order = 1; // 출력 순서
    while (true) {
        const pair<int, int>& front_doc = printer_queue.front();
        if (front_doc.second == priorities.top()) { // 해당 우선순위 찾음
            if (front_doc.first == m) { // 출력
                cout << order << '\n';
                break;
            }
            priorities.pop();
            printer_queue.pop();
            order++;
        }
        else { // 해당 우선순위 못 찾음
            printer_queue.push(printer_queue.front()); // 회전
            printer_queue.pop();
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int test_case;
    cin >> test_case;

    while (test_case--)
        run_printer();
    return 0;
}