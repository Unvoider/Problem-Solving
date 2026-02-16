import sys
input = sys.stdin.readline

n, k = map(int, input().split())
coins = reversed([int(input()) for _ in range(n)]) #동전 종류

coin_count = 0 #동전 개수
for coin in coins:
    if k == 0: break
    coin_count += k // coin
    k %= coin
print(coin_count)