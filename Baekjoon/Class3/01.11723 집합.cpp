#include <iostream>
using namespace std;

class BitmaskSet { // unsigned long long 비트마스크 세트
private:
    unsigned long long _set;
public:
    BitmaskSet() : _set(0) {};
    void add(int data) {
        _set |= 1ULL << (data - 1);
    }
    void remove(int data) {
        _set &= ~(1ULL << (data - 1));
    }
    bool check(int data) const {
        return (_set & (1ULL << (data - 1))) != 0;
    }
    void toggle(int data) {
        _set ^= 1ULL << (data - 1);
    }
    void all() {
        _set = ~0ULL;
    }
    void empty() {
        _set = 0;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int m;
    BitmaskSet s;

    cin >> m;
    while (m--) {
        int num;
        string command;
        cin >> command;
        if (command == "add") {
            cin >> num;
            s.add(num);
        }
        else if (command == "remove") {
            cin >> num;
            s.remove(num);
        }
        else if (command == "check") {
            cin >> num;
            cout << s.check(num) << '\n';
        }
        else if (command == "toggle") {
            cin >> num;
            s.toggle(num);
        }
        else if (command == "all") {
            s.all();
        }
        else if (command == "empty") {
            s.empty();
        }
    }
    return 0;
}

/* 라이브러리 사용
#include <iostream>
#include <bitset>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int m;
    bitset<21> s;

    cin >> m;
    while (m--) {
        int num;
        string command;
        cin >> command;
        if (command == "add") {
            cin >> num;
            s.set(num);
        }
        else if (command == "remove") {
            cin >> num;
            s.reset(num);
        }
        else if (command == "check") {
            cin >> num;
            cout << s.test(num) << '\n';
        }
        else if (command == "toggle") {
            cin >> num;
            s.flip(num);
        }
        else if (command == "all") {
            s.set();
        }
        else if (command == "empty") {
            s.reset();
        }
    }
    return 0;
}
*/