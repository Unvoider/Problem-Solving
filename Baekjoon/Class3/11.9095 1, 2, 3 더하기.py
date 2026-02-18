import sys
input = sys.stdin.readline

MAX_NUM = 10

sum_counts = [0] * (MAX_NUM + 1) #타뷸레이션
sum_counts[1] = 1 #1
sum_counts[2] = 2 #1 + 1, 2
sum_counts[3] = 4 #1 + 1 + 1, 1 + 2, 2 + 1, 3
for i in range(4, MAX_NUM + 1):
    sum_counts[i] = sum_counts[i - 3] + sum_counts[i - 2] + sum_counts[i - 1]

t = int(input())
out = [str(sum_counts[int(input())]) for _ in range(t)]
print("\n".join(out))