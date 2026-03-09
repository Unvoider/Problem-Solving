from collections import deque
import sys
input = sys.stdin.readline

#page, row, column
MOVE_DIR = ((-1, 0, 0), (1, 0, 0), (0, -1, 0), (0, 1, 0), (0, 0, -1), (0, 0, 1))
NO_TOMATO = -1
UNRIPE_TOMATO = -2

m, n, h = map(int, input().split())
unripe_tomato_count = 0
ripe_time = 0
depths = [[[NO_TOMATO] * m for _ in range(n)] for _ in range(h)] #격자 그래프
bfs = deque()
for p in range(h):
    for r in range(n):
        tomatoes = map(int, input().split())
        for c, tomato in enumerate(tomatoes):
            if tomato == 1: #익음
                bfs.append((p, r, c))
                depths[p][r][c] = 0
            elif tomato == 0: #익지 않음
                depths[p][r][c] = UNRIPE_TOMATO
                unripe_tomato_count += 1

while bfs: #너비 우선 탐색
    start_p, start_r, start_c = bfs.popleft()
    for move_p, move_r, move_c in MOVE_DIR:
        end_p = start_p + move_p
        end_r = start_r + move_r
        end_c = start_c + move_c
        if end_p < 0 or end_p >= h or end_r < 0 or end_r >= n or end_c < 0 or end_c >= m:
            continue
        if depths[end_p][end_r][end_c] == UNRIPE_TOMATO: #인접 토마토가 익지 않음
            bfs.append((end_p, end_r, end_c)) #익히기
            ripe_time = depths[end_p][end_r][end_c] = depths[start_p][start_r][start_c] + 1
            unripe_tomato_count -= 1

if unripe_tomato_count == 0:
    print(ripe_time)
else:
    print(-1)