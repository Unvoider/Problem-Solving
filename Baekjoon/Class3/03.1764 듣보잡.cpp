#include <iostream>
#include <unordered_set>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    unordered_set<string> unheard; // 듣도 못한 사람
    unheard.reserve(n);
    while (n--) {
        string name;
        cin >> name;
        unheard.insert(name);
    }

    vector<string> unheard_unseen; // 듣도 보도 못한 사람
    while (m--) {
        string name;
        cin >> name;
        if (unheard.find(name) != unheard.end())
            unheard_unseen.push_back(name);
    }

    sort(unheard_unseen.begin(), unheard_unseen.end()); // 사전순 정렬
    cout << unheard_unseen.size() << '\n';
    for (const string& name : unheard_unseen)
        cout << name << '\n';
    return 0;
}