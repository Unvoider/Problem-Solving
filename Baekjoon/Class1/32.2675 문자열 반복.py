import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    r, s = input().split()
    p = "".join([ch * int(r) for ch in s])
    print(p)