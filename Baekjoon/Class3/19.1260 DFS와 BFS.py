from collections import deque
import sys
input = sys.stdin.readline
write = sys.stdout.write

#깊이 우선 탐색
def dfs_(start, graph, visited):
    for end in graph[start]:
        if not visited[end]:
            visited[end] = True
            write(f"{end} ")
            dfs_(end, graph, visited)

def dfs(start, graph):
    visited = [False] * len(graph)
    visited[start] = True
    write(f"{start} ")
    dfs_(start, graph, visited)
    write("\n")

#너비 우선 탐색
def bfs(start, graph):
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

def main():
    n, m, v = map(int, input().split())

    graph = [[] for _ in range(n + 1)] #무방향성 그래프
    for _ in range(m):
        start, end = map(int, input().split())
        graph[start].append(end)
        graph[end].append(start)
    for node in graph: #정렬
        node.sort()

    dfs(v, graph)
    bfs(v, graph)

main()