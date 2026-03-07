import sys
input = sys.stdin.readline

n = int(input())
meetings = [tuple(map(int, input().split())) for _ in range(n)]
meetings.sort(key=lambda meeting: (meeting[1], meeting[0])) #끝나는 시간 기준 정렬

max_count = 0
prev_end = 0
for start, end in meetings:
    if prev_end <= start: #다음 미팅 추가
        max_count += 1
        prev_end = end

print(max_count)