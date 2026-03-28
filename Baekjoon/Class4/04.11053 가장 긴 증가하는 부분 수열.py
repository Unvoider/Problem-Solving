import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
max_lengths = [1] * n

for i in range(n):
    for j in range(i): #각 도착점의 최대 길이 찾기
        if a[i] > a[j]:
            max_lengths[i] = max(max_lengths[i], max_lengths[j] + 1)

print(max(max_lengths))