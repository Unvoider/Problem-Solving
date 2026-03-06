#너비 우선 탐색
from collections import deque
import sys
input = sys.stdin.readline

n = int(input())

graph = [[] for _ in range(n)] #인접 리스트
for i in range(n):
    row = input().rstrip().split()
    for j in range(n):
        if row[j] == "1":
            graph[i].append(j)

visited = [["0"] * n for _ in range(n)]
for node in range(n): #매 노드마다 모든 경로 찾기
    bfs = deque([node])
    while bfs:
        start = bfs.popleft()
        for end in graph[start]:
            if visited[node][end] == "0":
                visited[node][end] = "1"
                bfs.append(end)

print("\n".join(" ".join(visited[i]) for i in range(n)))

''' 플로이드-워셜
import sys
input = sys.stdin.readline

n = int(input())

graph = [list(map(int, input().rstrip().split())) for _ in range(n)] #인접 행렬

for k in range(n): #간접 경로
    for i in range(n):
        for j in range(n):
            if graph[i][k] and graph[k][j]:
                graph[i][j] = 1

print("\n".join(" ".join(map(str, graph[i])) for i in range(n)))
'''