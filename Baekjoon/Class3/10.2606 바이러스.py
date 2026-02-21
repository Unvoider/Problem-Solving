#너비 우선 탐색
from collections import deque
import sys
input = sys.stdin.readline

pc_n = int(input())
link_n = int(input())

graph = [[] for _ in range(pc_n + 1)] #무방향성 그래프
for _ in range(link_n):
    start, end = map(int, input().split(" "))
    graph[start].append(end)
    graph[end].append(start)

bfs = deque([1]) #1번 감염
visited = [False] * (pc_n + 1)
visited[1] = True
infected_count = 1
while bfs:
    start = bfs.popleft()
    for end in graph[start]:
        if not visited[end]:
            bfs.append(end)
            visited[end] = True
            infected_count += 1
print(infected_count - 1)

''' 깊이 우선 탐색
import sys
input = sys.stdin.readline

def dfs(start, graph, visited):
    visited[start] = True
    for end in graph[start]:
        if not visited[end]:
            dfs(end, graph, visited)

def main():
    pc_n = int(input())
    link_n = int(input())

    graph = [[] for _ in range(pc_n + 1)] #무방향성 그래프
    for _ in range(link_n):
        start, end = map(int, input().split(" "))
        graph[start].append(end)
        graph[end].append(start)
    
    visited = [False] * (pc_n + 1)
    dfs(1, graph, visited) #1번 감염
    print(visited.count(True) - 1)

main()
'''