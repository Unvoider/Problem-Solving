from collections import deque
import sys
input = sys.stdin.readline

MOVE_DIR = ((-1, 0), (1, 0), (0, -1), (0, 1))

n, m = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(n)] #격자 그래프
depths = [[0] * m for _ in range(n)]
bfs = deque()
for i, row in enumerate(graph):
    for j, num in enumerate(row):
        if num == 1:
            depths[i][j] = -1
        if num == 2: #목표 지점
            bfs.append((i, j))

while bfs: #너비 우선 탐색
    start_x, start_y = bfs.popleft()
    for move_x, move_y in MOVE_DIR:
        end_x = start_x + move_x
        end_y = start_y + move_y
        if end_x < 0 or end_x >= n or end_y < 0 or end_y >= m:
            continue
        if graph[end_x][end_y] == 1: #갈 수 있음
            graph[end_x][end_y] = 0 #방문 표시
            depths[end_x][end_y] = depths[start_x][start_y] + 1 #깊이 계산
            bfs.append((end_x, end_y))

print("\n".join(" ".join(map(str, depths[i])) for i in range(n)))