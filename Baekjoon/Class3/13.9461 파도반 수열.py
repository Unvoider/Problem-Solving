import sys
input = sys.stdin.readline

MAX_NUM = 100

padovan = [0] * (MAX_NUM + 1) #타뷸레이션
padovan[1] = padovan[2] = padovan[3] = 1
padovan[4] = padovan[5] = 2
for i in range(6, MAX_NUM + 1):
    padovan[i] = padovan[i - 5] + padovan[i - 1]

t = int(input())
out = []
for _ in range(t):
    n = int(input())
    out.append(str(padovan[n]))
print("\n".join(out))