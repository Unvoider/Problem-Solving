#include <iostream>
#include <vector>
using namespace std;

template <typename T>
class MaxHeap {
private:
    vector<T> _heap;
public:
    MaxHeap() : _heap(vector<T>(1)) {} // root 인덱스 1
    bool empty() {
        return _heap.size() == 1;
    }
    void push(const T& data) {
        int in_pos = _heap.size(); // 마지막 인덱스를 삽입 위치로
        int parent = in_pos >> 1;
        _heap.push_back(NULL);
        while (in_pos != 1 && data > _heap[parent]) { // 삽입 위치가 root가 아니고 자식 값이 부모 값보다 큰 동안
            _heap[in_pos] = _heap[parent]; // 부모를 자식으로
            in_pos >>= 1; // 자식을 부모로
            parent = in_pos >> 1;
        }
        _heap[in_pos] = data;
    }
    T pop() {
        if (empty()) throw out_of_range("heap is empty");
        T data = _heap[1];
        T last = _heap.back(); // 마지막 값을 root 자리에 올림
        _heap.pop_back();
        if (empty()) return data;
        int in_pos = 1;
        int child = 2;
        size_t heap_size = _heap.size();
        while (child < heap_size) { // 자식이 존재하는 동안
            if (child + 1 < heap_size && _heap[child] < _heap[child + 1])
                child++; // 왼쪽/오른쪽 자식 중 더 큰 값 고르기
            if (last >= _heap[child]) break; // 부모 값이 자식 값보다 작은 동안
            _heap[in_pos] = _heap[child]; // 자식을 부모로
            in_pos = child; // 부모를 자식으로
            child = in_pos << 1;
        }
        _heap[in_pos] = last;
        return data;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    MaxHeap<int> max_heap;
    while (n--) {
        int x;
        cin >> x;
        if (x == 0)
            if (max_heap.empty())
                cout << "0\n";
            else
                cout << max_heap.pop() << '\n';
        else
            max_heap.push(x);
    }
    return 0;
}

/* 라이브러리 사용
#include <iostream>
#include <queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    priority_queue<int> max_heap;

    int n;
    cin >> n;
    while (n--) {
        int x;
        cin >> x;
        if (x == 0)
            if (max_heap.empty())
                cout << "0\n";
            else {
                cout << max_heap.top() << '\n';
                max_heap.pop();
            }
        else
            max_heap.push(x);
    }
    return 0;
}
*/