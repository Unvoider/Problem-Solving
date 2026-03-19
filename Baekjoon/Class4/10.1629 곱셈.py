import sys
input = sys.stdin.readline

'''
a^n
= a if n==1,
= (a^(n/2))^2 if n%2==0,
= a*(a^((n-1)/2))^2 if n%2==1
'''

def power_mod(base, exp, div):
    if (exp == 1): return base % div #1일 때
    half = power_mod(base, exp // 2, div)
    whole = (half * half) % div
    if (exp % 2 == 0): return whole; #짝수일 때
    return ((base % div) * whole) % div #홀수일 때

a, b, c = map(int, input().split())
print(power_mod(a, b, c))