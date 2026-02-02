import sys
input = sys.stdin.readline

t = int(input())
for _ in range(0, t):
    h, w, n = map(int, input().split())
    y = (n - 1) % h + 1
    x = (n - 1) // h + 1
    print(y * 100 + x)