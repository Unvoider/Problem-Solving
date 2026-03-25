#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k;
    cin >> n >> k;

    vector<int> max_acc_vals(k + 1); // 가방 용량에 따른 모든 물건 가치 누적
    for (int _ = 0; _ < n; _++) {
        int w, v;
        cin >> w >> v;
        for (int i = k; i >= w; i--) // _번째 물건이 중복 처리되는 것을 방지하기 위해 역순으로 처리
            // 해당 물건을 넣지 않았을 때의 최댓값과, 해당 물건을 넣었을 때 나머지 용량에 넣을 수 있는 최댓값 비교
            max_acc_vals[i] = max(max_acc_vals[i], v + max_acc_vals[i - w]);
    }

    cout << max_acc_vals[k];
    return 0;
}

/* 2차원
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Item {
    int weight, value;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k;
    cin >> n >> k;

    vector<Item> items(n + 1);
    for (int i = 1; i <= n; i++)
        cin >> items[i].weight >> items[i].value;

    vector<vector<int>> max_acc_vals(n + 1, vector<int>(k + 1)); // 가방 용량에 따른 모든 물건 가치 누적
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= k; j++)
            if(items[i].weight <= j) // 해당 물건의 무게가 가방 용량보다 적다면
                // 해당 물건을 넣지 않았을 때의 최댓값과, 해당 물건을 넣었을 때 나머지 용량에 넣을 수 있는 최댓값 비교
                max_acc_vals[i][j] = max(max_acc_vals[i - 1][j], items[i].value + max_acc_vals[i - 1][j - items[i].weight]);
            else
                // 해당 물건을 넣지 않았을 때의 최댓값
                max_acc_vals[i][j] = max_acc_vals[i - 1][j];

    cout << max_acc_vals[n][k];
    return 0;
}
*/