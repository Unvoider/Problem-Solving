#include <iostream>
#include <queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k;
    queue<int> people;

    cin >> n >> k;
    for (int i = 1; i <= n; i++)
        people.push(i);

    cout << '<';
    while (true) {
        for (int _ = k; _ > 1; _--) { // k - 1번 이동
            people.push(people.front());
            people.pop();
        }
        cout << people.front(); // k번째 사람
        people.pop();
        if (people.empty()) break;
        cout << ", ";
    }
    cout << '>';

    return 0;
}