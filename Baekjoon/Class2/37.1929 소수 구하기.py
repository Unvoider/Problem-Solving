#에라토스테네스의 체 O(NloglogN)
import sys
input = sys.stdin.readline
write = sys.stdout.write

def get_sieve(max):
    is_prime = [True] * (max + 1)
    is_prime[0] = is_prime[1] = False
    for i in range(2, int(max ** 0.5) + 1): #2부터 sqrt(max)까지 소수 찾기
        if is_prime[i]:
            for j in range(i * i, max + 1, i): #소수면 제곱부터 배수를 지우기
                is_prime[j] = False
    return is_prime

def main():
    n, m = map(int, input().split(" "))
    is_prime = get_sieve(m)
    for i in range(n, m + 1):
        if is_prime[i]:
            write(f"{str(i)}\n")

main()