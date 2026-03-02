from collections import deque
import sys
input = sys.stdin.readline

MOVE_DIR = ((-1, 0), (1, 0), (0, -1), (0, 1))

n, m = map(int, input().split())

# 벽 0, 길 -1
depths = [[-1 if ch == "1" else 0 for ch in input().rstrip()] for _ in range(n)]

bfs = deque([(0, 0)]) #출발 위치 (0, 0)
depths[0][0] = 1 #출발 깊이 1
while True:
    start_x, start_y = bfs.popleft()
    if start_x == n - 1 and start_y == m - 1: #도착 위치 (n - 1, m - 1)
        break
    for move_x, move_y in MOVE_DIR:
        end_x = start_x + move_x
        end_y = start_y + move_y
        if end_x < 0 or end_x >= n or end_y < 0 or end_y >= m: #경계 확인
            continue
        if depths[end_x][end_y] == -1: #이동
            bfs.append((end_x, end_y))
            depths[end_x][end_y] = depths[start_x][start_y] + 1

print(depths[n - 1][m - 1]) #도착 깊이