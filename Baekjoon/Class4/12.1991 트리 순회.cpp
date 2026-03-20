#include <iostream>
#include <utility>
#include <unordered_map>
using namespace std;
constexpr char EMPTY_NODE = '.';

unordered_map<int, pair<char, char>> tree;

void preorder(char node) {
    if (node == EMPTY_NODE) return;
    cout << node;
    preorder(tree[node].first);
    preorder(tree[node].second);
}

void inorder(char node) {
    if (node == EMPTY_NODE) return;
    inorder(tree[node].first);
    cout << node;
    inorder(tree[node].second);
}

void postorder(char node) {
    if (node == EMPTY_NODE) return;
    postorder(tree[node].first);
    postorder(tree[node].second);
    cout << node;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    for (int _ = 0; _ < n; _++) { // 이진 트리
        char parent, left, right;
        cin >> parent >> left >> right;
        tree[parent] = { left, right };
    }

    preorder('A'); cout << '\n'; // 탐색
    inorder('A'); cout << '\n';
    postorder('A'); cout << '\n';
    return 0;
}