// 에라토스테네스의 체 O(NloglogN)
#include <iostream>
#include <vector>
using namespace std;

struct Sieve {
    vector<char> is_prime;
    Sieve(int max) {
        is_prime = vector<char>(max + 1, true);
        is_prime[0] = is_prime[1] = false;
        for (int i = 2; i * i <= max; i++) // 2부터 sqrt(max)까지 소수 찾기
            if (is_prime[i])
                for (int j = i * i; j <= max; j += i) // 소수면 제곱부터 배수를 지우기
                    is_prime[j] = false;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;
    Sieve sieve(m);
    for (int i = n; i <= m; i++)
        if (sieve.is_prime[i])
            cout << i << '\n';
    return 0;
}