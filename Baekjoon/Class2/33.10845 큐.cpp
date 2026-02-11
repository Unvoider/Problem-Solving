#include <iostream>
#include <string>
using namespace std;

template <typename T> // 연결 리스트 큐
class Queue {
private:
    struct Node { // 연결 리스트 노드
        T data;
        Node* next;
    };
    Node* _front; // 첫 노드
    Node* _back; // 마지막 노드
    int _size;
public:
    Queue() : _front(nullptr), _back(nullptr), _size(0) {}
    ~Queue() {
        while (!empty())
            pop();
    }
    void push(const T& data) {
        _size++;
        Node* node_to_push = new Node;
        node_to_push->data = data;
        node_to_push->next = nullptr;
        if (_size == 1)
            _front = _back = node_to_push;
        else {
            _back->next = node_to_push;
            _back = node_to_push;
        }
    }
    T pop() {
        if (empty()) throw out_of_range("queue is empty");
        _size--;
        Node* node_to_pop = _front;
        T data = node_to_pop->data;
        _front = node_to_pop->next;
        delete node_to_pop;
        if (!_front) _back = nullptr;
        return data;
    }
    int size() {
        return _size;
    }
    bool empty() {
        return _size == 0;
    }
    T front() {
        if (empty()) throw out_of_range("queue is empty");
        return _front->data;
    }
    T back() {
        if (empty()) throw out_of_range("queue is empty");
        return _back->data;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    Queue<int> nums;

    cin >> n;
    while (n--) {
        string command;
        cin >> command;
        try {
            if (command == "push") {
                int num;
                cin >> num;
                nums.push(num);
            }
            else if (command == "pop")
                cout << nums.pop() << '\n';
            else if (command == "size")
                cout << nums.size() << '\n';
            else if (command == "empty")
                cout << nums.empty() << '\n';
            else if (command == "front")
                cout << nums.front() << '\n';
            else if (command == "back")
                cout << nums.back() << '\n';
        }
        catch (const out_of_range& e) { // 큐 빔
            cout << -1 << '\n';
        }
    }
    return 0;
}

/* 라이브러리 사용
#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    queue<int> nums;

    cin >> n;
    while (n--) {
        string command;
        cin >> command;
        if (command == "push") {
            int num;
            cin >> num;
            nums.push(num);
        }
        else if (command == "pop") {
            if (nums.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << nums.front() << '\n';
            nums.pop();
        }
        else if (command == "size")
            cout << nums.size() << '\n';
        else if (command == "empty")
            cout << nums.empty() << '\n';
        else if (command == "front") {
            if (nums.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << nums.front() << '\n';
        }
        else if (command == "back") {
            if (nums.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << nums.back() << '\n';
        }
    }
    return 0;
}
*/