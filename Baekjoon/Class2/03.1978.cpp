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

    int n, num, prime_n = 0;
    cin >> n;
    while (n--) {
        cin >> num;
        prime_n += is_prime(num);
    }
    cout << prime_n;
    return 0;
}