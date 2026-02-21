#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

long long count_cut_wire(long long length, const vector<long long>& wires) { // 잘린 선 개수
    long long count = 0;
    for (long long wire : wires)
        count += wire / length;
    return count;
}

long long max_cut_length(int required, const vector<long long>& wires) {
    long long answer = 0;
    long long left = 1LL, right = *max_element(wires.begin(), wires.end());
    while (left <= right) {
        long long middle = left + (right - left) / 2LL;
        if (count_cut_wire(middle, wires) >= required) { // 더 길게 자를 수도 있음
            left = middle + 1LL;
            answer = middle;
        }
        else // 더 짧게 잘라야 함
            right = middle - 1LL;
    }
    return answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int k, n;
    cin >> k >> n;

    vector<long long> wires(k);
    for (int i = 0; i < k; i++)
        cin >> wires[i];

    cout << max_cut_length(n, wires);
    return 0;
}