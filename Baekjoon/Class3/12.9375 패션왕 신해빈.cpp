#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int test_case;
    cin >> test_case;

    while (test_case--) {
        int n;
        cin >> n;

        unordered_map<string, int> clothes; // 옷의 종류
        while (n--) {
            string _, type;
            cin >> _ >> type;
            clothes[type]++;
        }

        int cases = 1; // 옷을 입는 경우의 수
        for (const auto& it : clothes)
            cases *= it.second + 1;
        cout << cases - 1 << '\n';
    }
    return 0;
}