#include <iostream>
#include <string>
using namespace std;

template <typename T> // 연결 리스트 스택
class Stack {
private:
    struct Node { // 연결 리스트 노드
        T data;
        Node* next;
    };
    Node* _top; // 첫 노드
    int _size;
public:
    Stack() : _top(nullptr), _size(0) {}
    ~Stack() {
        while (!empty())
            pop();
    }
    void push(const T& data) {
        _size++;
        Node* node_to_push = new Node;
        node_to_push->data = data;
        node_to_push->next = _top;
        _top = node_to_push;
    }
    T pop() {
        if (empty()) throw out_of_range("stack is empty");
        _size--;
        Node* node_to_pop = _top;
        T data = node_to_pop->data;
        _top = node_to_pop->next;
        delete node_to_pop;
        return data;
    }
    int size() {
        return _size;
    }
    bool empty() {
        return _size == 0;
    }
    T top() {
        if (empty()) throw out_of_range("stack is empty");
        return _top->data;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    Stack<int> nums;

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
            else if (command == "top")
                cout << nums.top() << '\n';
        }
        catch (const out_of_range& e) { // 스택 빔
            cout << -1 << '\n';
        }
    }
    return 0;
}

/* 라이브러리 사용
#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    stack<int> nums;

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
            cout << nums.top() << '\n';
            nums.pop();
        }
        else if (command == "size")
            cout << nums.size() << '\n';
        else if (command == "empty")
            cout << nums.empty() << '\n';
        else if (command == "top") {
            if (nums.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << nums.top() << '\n';
        }
    }
    return 0;
}
*/