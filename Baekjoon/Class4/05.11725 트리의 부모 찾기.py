from collections import deque
import sys
input = sys.stdin.readline

n = int(input())

graph = [[] for _ in range(n + 1)] #무방향성 그래프
for _ in range(1, n):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)

parents = [0] * (n + 1)
bfs = deque([1]) #루트에서부터 너비 우선 탐색
parents[1] = -1
while bfs:
    start = bfs.popleft()
    for end in graph[start]:
        if parents[end] == 0: #부모 설정
            parents[end] = start
            bfs.append(end)

print("\n".join(str(parents[i]) for i in range(2, n + 1)))