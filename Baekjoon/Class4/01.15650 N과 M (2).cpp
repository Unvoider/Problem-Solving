#include <iostream>
#include <vector>
using namespace std;

int n, m;
vector<char> visited;
vector<int> track;

void back_track(int start) {
    if (track.size() == m) { // 출력
        for (int num : track)
            cout << num << ' ';
        cout << '\n';
        return;
    }
    for (int i = start; i <= n; i++) {
        if (!visited[i]) {
            track.push_back(i); // 추가
            visited[i] = true;
            back_track(i + 1);
            track.pop_back(); // 삭제
            visited[i] = false;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;
    visited = vector<char>(n + 1);
    back_track(1);
    return 0;
}