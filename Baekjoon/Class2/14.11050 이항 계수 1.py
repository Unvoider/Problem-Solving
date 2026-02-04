import sys
input = sys.stdin.readline

def binomial_coefficient(n, k):
    result = 1
    if k > n // 2: #k가 n의 절반보다 크면 n - k로 교체
        k = n - k
    for i in range(1, k + 1):
        result *= n + 1 - i
        result //= i
    return result

def main():
    n, k = map(int, input().split())
    print(binomial_coefficient(n, k))

main()