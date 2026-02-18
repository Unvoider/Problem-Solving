import sys
input = sys.stdin.readline

DIVISOR = 10007

n = int(input())

tiling_cases = [0] * (n + 1) #타뷸레이션
if n >= 1:
    tiling_cases[1] = 1
if n >= 2:
    tiling_cases[2] = 3
for i in range(3, n + 1):
    tiling_cases[i] = (tiling_cases[i - 2] * 2 + tiling_cases[i - 1]) % DIVISOR

print(tiling_cases[n])