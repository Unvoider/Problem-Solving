from collections import deque
import sys
input = sys.stdin.readline

n, k = map(int, input().split())
depth_limit = max(n, k) * 2

dq = deque() #0-1 너비 우선 탐색
depths = [-1] * (depth_limit + 1)
dq.append(n) #시작
depths[n] = 0

while dq:
    start = dq.popleft()
    if start == k:
        break

    end = start * 2
    if end <= depth_limit and depths[end] == -1: #순간 이동
        dq.appendleft(end)
        depths[end] = depths[start]

    for end in (start - 1, start + 1): #걷기
        if end >= 0 and end <= depth_limit and depths[end] == -1:
            dq.append(end)
            depths[end] = depths[start] + 1

print(depths[k])