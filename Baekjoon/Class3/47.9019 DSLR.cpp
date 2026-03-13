#include <iostream>
#include <utility>
#include <vector>
#include <queue>
using namespace std;

constexpr int MAX_NUM = 9999;
constexpr int DIGIT_LIMIT = 10000;
constexpr int NOT_VISITED = -1;
constexpr int BEGINNING = -2;
constexpr char SYMBOLS[] = { 'D', 'S', 'L', 'R' };

void run_register() {
    int a, b;
    cin >> a >> b;

    vector<pair<char, int>> operations(MAX_NUM + 1, { '\0', NOT_VISITED }); // <operation, prev_index>
    queue<int> bfs; // 너비 우선 탐색
    bfs.push(a);
    operations[a].second = BEGINNING;
    while (!bfs.empty()) {
        int start = bfs.front();
        bfs.pop();

        int ends[] = { // DSLR 계산
            (2 * start) % DIGIT_LIMIT,
            start == 0 ? MAX_NUM : start - 1,
            (start * 10) % DIGIT_LIMIT + start / (DIGIT_LIMIT / 10), // shift left + carry
            (start / 10) + (start % 10) * (DIGIT_LIMIT / 10) // shift right + carry * 1000
        };

        for (int i = 0; i < 4; i++) {
            int end = ends[i];
            if (operations[end].second == NOT_VISITED) { // 연산자 저장
                bfs.push(end);
                operations[end] = { SYMBOLS[i], start };
            }
            if (end == b) { // B 도착
                vector<char> trace;
                pair<char, int>* cur = &operations[end]; // 역추적
                while (cur->second != BEGINNING) {
                    trace.push_back(cur->first);
                    cur = &operations[cur->second];
                }
                for (auto it = trace.rbegin(); it != trace.rend(); it++)
                    cout << *it;
                cout << '\n';
                return;
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--)
        run_register();
    return 0;
}