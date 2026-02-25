from collections import deque
import sys
input = sys.stdin.readline

def count_components(graph):
    count = 0
    bfs = deque()
    visited = [False] * len(graph)
    for i in range(1, len(graph)):
        if visited[i]:
            continue
        bfs.append(i) #컴포넌트 발견
        visited[i] = True
        count += 1
        while bfs:
            start = bfs.popleft()
            for end in graph[start]:
                if not visited[end]:
                    bfs.append(end)
                    visited[end] = True
    return count

def main():
    n, m = map(int, input().split())

    graph = [[] for _ in range(n + 1)] #무방향성 그래프
    for _ in range(m):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)

    print(count_components(graph))

main()