#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Meeting {
    int start, end;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<Meeting> meetings(n);
    for (int i = 0; i < n; i++)
        cin >> meetings[i].start >> meetings[i].end;
    sort(meetings.begin(), meetings.end(), [](const Meeting& m1, const Meeting& m2) {
        if (m1.end != m2.end) return m1.end < m2.end;
        return m1.start < m2.start;
    }); // 끝나는 시간 기준 정렬

    int max_count = 1; // 첫 미팅
    int prev_end = meetings[0].end;
    for (int i = 1; i < n; i++)
        if (prev_end <= meetings[i].start) { // 다음 미팅 추가
            max_count++;
            prev_end = meetings[i].end;
        }

    cout << max_count;
    return 0;
}