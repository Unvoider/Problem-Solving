from collections import deque
import sys
input = sys.stdin.readline
write = sys.stdout.write

n, m, v = map(int, input().split())

graph = [[] for _ in range(n + 1)] #무방향성 그래프
for _ in range(m):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)
for node in graph: #정렬
    node.sort()

#깊이 우선 탐색
def dfs_recursive(start, visited):
    visited[start] = True
    write(f"{start} ")
    for end in graph[start]:
        if not visited[end]:
            dfs_recursive(end, visited)

def dfs(start):
    visited = [False] * len(graph)
    dfs_recursive(start, visited)
    write("\n")

#너비 우선 탐색
def bfs(start):
    d = deque([start])
    visited = [False] * len(graph)
    visited[start] = True
    write(f"{start} ")
    while d:
        start = d.popleft()
        for end in graph[start]:
            if not visited[end]:
                d.append(end)
                visited[end] = True
                write(f"{end} ")
    write("\n")

dfs(v)
bfs(v)