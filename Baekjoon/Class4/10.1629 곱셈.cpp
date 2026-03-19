#include <iostream>
using namespace std;

/*
a^n
= a if n==1,
= (a^(n/2))^2 if n%2==0,
= a*(a^((n-1)/2))^2 if n%2==1
*/

long long power_mod(long long base, long long exp, long long div) {
    if (exp == 1) return base % div; // 1일 때
    long long half = power_mod(base, exp / 2, div);
    long long whole = (half * half) % div;
    if (exp % 2 == 0) return whole; // 짝수일 때
    return ((base % div) * whole) % div; // 홀수일 때
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long a, b, c;
    cin >> a >> b >> c;
    cout << power_mod(a, b, c);
    return 0;
}