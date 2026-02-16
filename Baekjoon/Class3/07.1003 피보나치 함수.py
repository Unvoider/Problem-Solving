#반복 동적 프로그래밍
import sys
input = sys.stdin.readline
write = sys.stdout.write

FIB_MAX = 40

#타뷸레이션
zero_count = [0] * (FIB_MAX + 2)
zero_count[0] = 1
for i in range(2, FIB_MAX + 2):
    zero_count[i] = zero_count[i - 1] + zero_count[i - 2]

t = int(input())
for _ in range(t):
    n = int(input())
    write(f"{zero_count[n]} {zero_count[n + 1]}\n")

''' 재귀 동적 프로그래밍
import sys
input = sys.stdin.readline
write = sys.stdout.write

FIB_MAX = 40

#메모이제이션
zero_count = [0] * (FIB_MAX + 2)
zero_count[0] = 1

def count_fib(n):
    if n < 2: return
    if zero_count[n] != 0: return
    count_fib(n - 1)
    count_fib(n - 2)
    zero_count[n] = zero_count[n - 1] + zero_count[n - 2]

def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        count_fib(n + 1)
        write(f"{zero_count[n]} {zero_count[n + 1]}\n")

main()
'''