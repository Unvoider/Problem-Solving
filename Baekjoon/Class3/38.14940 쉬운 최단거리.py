from collections import deque
import sys
input = sys.stdin.readline

MOVE_DIR = ((-1, 0), (1, 0), (0, -1), (0, 1))

n, m = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(n)] #격자 그래프
depths = [[0] * m for _ in range(n)]
bfs = deque()
for r, row in enumerate(graph):
    for c, num in enumerate(row):
        if num == 1:
            depths[r][c] = -1
        if num == 2: #목표 지점
            bfs.append((r, c))

while bfs: #너비 우선 탐색
    start_r, start_c = bfs.popleft()
    for move_r, move_c in MOVE_DIR:
        end_r = start_r + move_r
        end_c = start_c + move_c
        if end_r < 0 or end_r >= n or end_c < 0 or end_c >= m:
            continue
        if graph[end_r][end_c] == 1: #갈 수 있음
            graph[end_r][end_c] = 0 #방문 표시
            depths[end_r][end_c] = depths[start_r][start_c] + 1 #깊이 계산
            bfs.append((end_r, end_c))

print("\n".join(" ".join(map(str, depths[i])) for i in range(n)))