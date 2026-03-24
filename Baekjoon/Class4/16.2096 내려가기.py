import sys
input = sys.stdin.readline

TABLE_SIZE = 3

n = int(input())

prev_max_table = None
prev_min_table = None
max_table = list(map(int, input().split())) #첫 열
min_table = max_table[:]

for i in range(1, n):
    prev_max_table = max_table[:] #슬라이딩 윈도우
    prev_min_table = min_table[:]
    max_table = list(map(int, input().split())) #다음 열
    min_table = max_table[:]

    max_table[0] += max(prev_max_table[0], prev_max_table[1]) #최댓값 누적
    max_table[1] += max(prev_max_table)
    max_table[2] += max(prev_max_table[1], prev_max_table[2])
    min_table[0] += min(prev_min_table[0], prev_min_table[1]) #최솟값 누적
    min_table[1] += min(prev_min_table)
    min_table[2] += min(prev_min_table[1], prev_min_table[2])

print(f"{max(max_table)} {min(min_table)}")