#include <iostream>
#include <vector>
using namespace std;

int n, m;
vector<int> track;

void back_track(int start) {
    if (track.size() == m) { // 출력
        for (int num : track)
            cout << num << ' ';
        cout << '\n';
        return;
    }
    for (int i = start; i <= n; i++) {
        track.push_back(i); // 추가
        back_track(i);
        track.pop_back(); // 삭제
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;
    back_track(1);
    return 0;
}