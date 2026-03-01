#너비 우선 탐색
from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)] #무방향성 그래프
for _ in range(m):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)

min_kevin = float("inf")
min_kevin_idx = 0
for i in range(1, n + 1):
    kevin = 0
    bfs = deque() #너비 우선 탐색
    depths = [-1] * (n + 1)
    bfs.append(i)
    depths[i] = 0
    while bfs:
        start = bfs.popleft()
        for end in graph[start]:
            if depths[end] == -1:
                bfs.append(end)
                depths[end] = depths[start] + 1
                kevin += depths[end] #케빈 베이컨 수 누적
    if min_kevin > kevin:
        min_kevin = kevin
        min_kevin_idx = i

print(min_kevin_idx)

''' 플로이드-워셜
import sys
input = sys.stdin.readline

MAX_USERS = 100

n, m = map(int, input().split())

graph = [[MAX_USERS] * (n + 1) for _ in range(n + 1)] #격자 그래프
for _ in range(m):
    start, end = map(int, input().split())
    graph[start][end] = 1
    graph[end][start] = 1

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]) #지름길 찾기

for i in range(1, n + 1): #자기 자신에 대한 경로 0
    graph[i][i] = 0

min_kevin = float("inf")
min_kevin_idx = 0
for i in range(1, n + 1):
    kevin = sum(graph[i][1:]) #케빈 베이컨 수 누적
    if min_kevin > kevin:
        min_kevin = kevin
        min_kevin_idx = i

print(min_kevin_idx)
'''