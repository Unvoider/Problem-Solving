#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, last_room = 1, dist = 1;
    cin >> n;
    while (n > last_room) {
        last_room += dist * 6; // 마지막 방 번호가 i * 6씩 증가함
        dist++;
    }
    cout << dist;
    return 0;
}