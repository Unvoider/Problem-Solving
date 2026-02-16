import sys
input = sys.stdin.readline

n = int(input())

#타뷸레이션
count_table = [0] * (n + 1)
for i in range(2, n + 1):
    a = b = c = count_table[i - 1] + 1
    if i % 3 == 0: #3으로 나눠 떨어지면
        b = count_table[i // 3] + 1
    if i % 2 == 0: #2로 나눠 떨어지면
        c = count_table[i // 2] + 1
    count_table[i] = min(a, b, c)
print(count_table[n])