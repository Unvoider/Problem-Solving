#include <iostream>
#include <array>
using namespace std;
constexpr int MAX_ARRAY = 1001;

// 에라토스테네스의 체 O(NloglogN)
struct Sieve {
    array<bool, MAX_ARRAY> is_prime;
    Sieve() {
        is_prime.fill(true);
        is_prime[0] = is_prime[1] = false;
        for (int i = 2; i * i < MAX_ARRAY; i++) // 2부터 sqrt(1001) 전까지 소수 찾기
            if (is_prime[i])
                for (int j = i * i; j < MAX_ARRAY; j += i) // 소수면 제곱부터 배수를 지우기
                    is_prime[j] = false;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, num, prime_count = 0;
    Sieve sieve;
    cin >> n;
    while (n--) {
        cin >> num;
        prime_count += sieve.is_prime[num];
    }
    cout << prime_count;
    return 0;
}

/* 홀수만 찾기
#include <iostream>
using namespace std;

int is_prime(int num) {
    if (num <= 1) return 0;
    if (num == 2) return 1;
    if (num % 2 == 0) return 0;
    for (int i = 3; i * i <= num; i += 2)
        if (num % i == 0) return 0;
    return 1;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, num, prime_count = 0;
    cin >> n;
    while (n--) {
        cin >> num;
        prime_count += is_prime(num);
    }
    cout << prime_count;
    return 0;
}
*/