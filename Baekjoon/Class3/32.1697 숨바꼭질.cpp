#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
constexpr int MAX_POS = 100000;

class HideAndSeek {
private:
    int _seek_time;
public:
    HideAndSeek(int seeker, int hider) {
        queue<int> bfs;
        vector<int> depths(MAX_POS + 1, -1);

        bfs.push(seeker); // 너비 우선 탐색
        depths[seeker] = 0;
        while (true) {
            int start = bfs.front();
            bfs.pop();
            if (start == hider) // 찾음
                break;
            int ends[] = { start - 1, start + 1, start * 2 }; // 못 찾음
            for (int end : ends) {
                if (end >= 0 && end <= MAX_POS && depths[end] == -1) {
                    bfs.push(end);
                    depths[end] = depths[start] + 1;
                }
            }
        }

        _seek_time = depths[hider];
    }
    int get_seek_time() const {
        return _seek_time;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k;
    cin >> n >> k;

    cout << HideAndSeek(n, k).get_seek_time();
    return 0;
}