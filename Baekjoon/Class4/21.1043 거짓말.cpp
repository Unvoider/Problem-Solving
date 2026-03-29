#include <iostream>
#include <vector>
using namespace std;

vector<char> knows;
vector<int> parents;

int collapsing_find(int node) {
    if (parents[node] == node) // 루트 반환
        return node;
    return parents[node] = collapsing_find(parents[node]); // 자손 노드들을 루트 노드에 달기
}

void union_roots(int node1, int node2) {
    node1 = collapsing_find(node1);
    node2 = collapsing_find(node2);

    if (node1 != node2) { // 두 루트가 다르다면
        if (knows[node1]) knows[node2] = true; // 지식 전파
        else if (knows[node2]) knows[node1] = true;
        parents[node1] = node2; // 유니언
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m, knowing_count; // 사람 수, 파티 수, 아는 사람 수
    cin >> n >> m >> knowing_count;

    knows = vector<char>(n + 1);
    parents = vector<int>(n + 1);
    for (int i = 1; i <= n; i++) // 루트는 자기 자신을 부모로
        parents[i] = i;

    for (int i = 0; i < knowing_count; i++) { // 아는 사람 설정
        int knowing_person;
        cin >> knowing_person;
        knows[knowing_person] = true;
    }

    vector<vector<int>> parties(m);
    for (int i = 0; i < m; i++) {
        int visitor_count;
        cin >> visitor_count;
        parties[i] = vector<int>(visitor_count);
        for (int j = 0; j < visitor_count; j++) // 파티 참석자 정보
            cin >> parties[i][j];
        for (int j = 0; j < visitor_count - 1; j++) // 파티 참석자 유니언 및 지식 전파
            union_roots(parties[i][j], parties[i][j + 1]);
    }

    int possible_lie_count = 0;
    for (const vector<int>& party : parties) {
        bool can_lie = true;
        for (int visitor : party) // 파티마다
            if (knows[collapsing_find(visitor)]) { // 아는 사람이 있으면 거짓말을 못 함
                can_lie = false;
                break;
            }
        if (can_lie) possible_lie_count++;
    }

    cout << possible_lie_count;
    return 0;
}