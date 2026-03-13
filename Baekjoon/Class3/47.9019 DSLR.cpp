// 단방향 BFS
#include <iostream>
#include <utility>
#include <vector>
#include <queue>
using namespace std;

constexpr int MAX_NUM = 9999;
constexpr int DIGIT_LIMIT = 10000;
constexpr int NOT_VISITED = -1;
constexpr int BEGINNING = -2;
constexpr char OPERATIONS[] = { 'D', 'S', 'L', 'R' };

void run_register() {
    int a, b;
    cin >> a >> b;

    vector<pair<char, int>> operations(MAX_NUM + 1, { '\0', NOT_VISITED }); // <operation, prev_index>
    queue<int> bfs; // 너비 우선 탐색
    bfs.push(a);
    operations[a].second = BEGINNING;
    while (true) {
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
                operations[end] = { OPERATIONS[i], start };
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

/* 양방향 BFS
#include <iostream>
#include <utility>
#include <vector>
#include <queue>
using namespace std;

constexpr int MAX_NUM = 9999;
constexpr int DIGIT_LIMIT = 10000;
constexpr int NOT_VISITED = -1;
constexpr int BEGINNING = -2;
constexpr int NOT_FOUND = -1;

void print_traces(
    int meeting_point,
    vector<pair<char, int>>& a_operations,
    vector<pair<char, int>>& b_operations
) {
    vector<char> a_trace;
    pair<char, int>* cur = &a_operations[meeting_point]; // A 역추적
    while (cur->second != BEGINNING) {
        a_trace.push_back(cur->first);
        cur = &a_operations[cur->second];
    }
    for (auto it = a_trace.rbegin(); it != a_trace.rend(); it++)
        cout << *it;

    cur = &b_operations[meeting_point]; // B 역추적
    while (cur->second != BEGINNING) {
        cout << cur->first;
        cur = &b_operations[cur->second];
    }
    cout << '\n';
}

int find_meeting_point(
    int start,
    const vector<pair<char, int>>& ends,
    queue<int>& bfs,
    vector<pair<char, int>>& operations,
    vector<pair<char, int>>& other_operations
) {
    for (int i = 0; i < ends.size(); i++) {
        char operation = ends[i].first;
        int end = ends[i].second;
        if (operations[end].second == NOT_VISITED) { // 연산자 저장
            bfs.push(end);
            operations[end] = { operation, start };
        }
        if (other_operations[end].second != NOT_VISITED) // 반대편과 만남
            return end;
    }
    return NOT_FOUND;
}

void run_register() {
    int a, b;
    cin >> a >> b;
    if (a == b) {
        cout << '\n';
        return;
    }

    vector<pair<char, int>> a_operations(MAX_NUM + 1, { '\0', NOT_VISITED }); // <operation, prev_index>
    vector<pair<char, int>> b_operations(MAX_NUM + 1, { '\0', NOT_VISITED });
    queue<int> a_bfs; // 너비 우선 탐색
    queue<int> b_bfs;
    a_bfs.push(a);
    b_bfs.push(b);
    a_operations[a].second = BEGINNING;
    b_operations[b].second = BEGINNING;

    while (true) {
        int level_size = a_bfs.size();
        for (int _ = 0; _ < level_size; _++) { // 한 레벨씩
            int start = a_bfs.front();
            a_bfs.pop();

            // 정방향 DSLR 계산
            vector<pair<char, int>> ends = { // <operation, end>
                pair<char, int>{ 'D', (2 * start) % DIGIT_LIMIT },
                pair<char, int>{ 'S', start == 0 ? MAX_NUM : start - 1 },
                pair<char, int>{ 'L', (start * 10) % DIGIT_LIMIT + start / (DIGIT_LIMIT / 10) }, // shift left + carry
                pair<char, int>{ 'R', (start / 10) + (start % 10) * (DIGIT_LIMIT / 10) } // shift right + carry * 1000
            };

            // 정방향 탐색
            int meeting_point = find_meeting_point(start, ends, a_bfs, a_operations, b_operations);
            if (meeting_point != NOT_FOUND) {
                print_traces(meeting_point, a_operations, b_operations);
                return;
            }
        }

        level_size = b_bfs.size();
        for (int _ = 0; _ < level_size; _++) {
            int start = b_bfs.front();
            b_bfs.pop();

            // 역방향 DSLR 계산
            vector<pair<char, int>> ends;
            if (start % 2 == 0) {
                ends.push_back(pair<char, int>{ 'D', start / 2 });
                ends.push_back(pair<char, int>{ 'D', (start + DIGIT_LIMIT) / 2 });
            }
            ends.push_back(pair<char, int>{ 'S', start == MAX_NUM ? 0 : start + 1 });
            ends.push_back(pair<char, int>{ 'L', (start / 10) + (start % 10) * (DIGIT_LIMIT / 10) }); // shift right + carry * 1000
            ends.push_back(pair<char, int>{ 'R', (start * 10) % 10000 + start / (DIGIT_LIMIT / 10) }); // shift left + carry

            // 역방향 탐색
            int meeting_point = find_meeting_point(start, ends, b_bfs, b_operations, a_operations);
            if (meeting_point != NOT_FOUND) {
                print_traces(meeting_point, a_operations, b_operations);
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
*/