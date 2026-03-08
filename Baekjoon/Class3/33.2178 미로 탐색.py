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
    start_r, start_c = bfs.popleft()
    if start_r == n - 1 and start_c == m - 1: #도착 위치 (n - 1, m - 1)
        break
    for move_r, move_c in MOVE_DIR:
        end_r = start_r + move_r
        end_c = start_c + move_c
        if end_r < 0 or end_r >= n or end_c < 0 or end_c >= m: #경계 확인
            continue
        if depths[end_r][end_c] == -1: #이동
            bfs.append((end_r, end_c))
            depths[end_r][end_c] = depths[start_r][start_c] + 1

print(depths[n - 1][m - 1]) #도착 깊이