#include <iostream>
#include <queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    queue<int> cards;
    for (int i = 1; i <= n; i++)
        cards.push(i);

    while (cards.size() > 1) {
        cards.pop(); // 맨 위 제거
        cards.push(cards.front()); // 맨 위 -> 맨 아래
        cards.pop();
    }

    cout << cards.front();
    return 0;
}