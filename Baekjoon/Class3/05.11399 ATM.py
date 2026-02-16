import sys
input = sys.stdin.readline

n = int(input())
time_list = sorted(list(map(int, input().split()))) #인출하는 데 걸리는 시간
min_total = 0 #시간 합의 최솟값
for i, time in enumerate(time_list):
    min_total += time * (n - i)
print(min_total)