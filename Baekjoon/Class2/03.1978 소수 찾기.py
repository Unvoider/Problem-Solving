#에라토스테네스의 체 O(NloglogN)
import sys
input = sys.stdin.readline

def get_sieve(max):
    is_prime = [True] * (max + 1)
    is_prime[0] = is_prime[1] = False
    for i in range(2, int(max ** 0.5) + 1): #2부터 sqrt(1000)까지 소수 찾기
        if is_prime[i]:
            for j in range(i * i, max + 1, i): #소수면 제곱부터 배수를 지우기
                is_prime[j] = False
    return is_prime

def main():
    _ = int(input())
    nums = map(int, input().split())
    is_prime = get_sieve(1000)
    prime_count = sum(is_prime[num] for num in nums)
    print(prime_count)

main()

''' 홀수만 찾기
import sys
input = sys.stdin.readline

def is_prime(num):
    if num <= 1: return 0
    if num == 2: return 1
    if num % 2 == 0: return 0
    for i in range(3, int(num ** 0.5) + 1, 2):
        if num % i == 0: return 0
    return 1

def main():
    _ = int(input())
    nums = map(int, input().split())
    prime_count = sum(map(is_prime, nums))
    print(prime_count)

main()
'''