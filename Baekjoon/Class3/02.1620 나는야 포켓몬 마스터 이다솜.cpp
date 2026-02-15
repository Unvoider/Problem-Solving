#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

class Pokedex {
private:
    int _size;
    vector<string> _index_to_name;
    unordered_map<string, int> _name_to_index;
public:
    Pokedex(int reserve_size) {
        _size = 0;
        _index_to_name.reserve(reserve_size + 1);
        _index_to_name.push_back("Dummy"); // 0번 인덱스 더미 데이터
        _name_to_index.reserve(reserve_size);
    }
    void add(const string& name) {
        _size++;
        _index_to_name.push_back(name);
        _name_to_index.insert({ name, _size });
    }
    const string& get_name(int index) const {
        return _index_to_name[index];
    }
    int get_index(const string& name) const {
        return _name_to_index.at(name);
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    Pokedex pokedex(n);

    while (n--) { // 이름 등록
        string name;
        cin >> name;
        pokedex.add(name);
    }

    while (m--) { // 검색
        string target;
        cin >> target;
        if (isdigit(target[0])) { // 인덱스 검색
            int index = stoi(target);
            cout << pokedex.get_name(index) << '\n';
        }
        else // 이름 검색
            cout << pokedex.get_index(target) << '\n';
    }
    return 0;
}