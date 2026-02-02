#include <iostream>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    while (n--) {
        int score = 0, total = 0;
        string input;
        cin >> input;
        for (int i = 0; i < input.length(); i++)
            if (input[i] == 'O')
                total += ++score;
            else
                score = 0;
        cout << total << '\n';
    }
}