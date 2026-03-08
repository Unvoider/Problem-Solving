from collections import deque
import sys
input = sys.stdin.readline

MOVE_DIR = ((-1, 0), (1, 0), (0, -1), (0, 1))
HOUSE = "1"
EMPTY = "0"

n = int(input())
houses = [list(input().rstrip()) for _ in range(n)]

house_counts = []
bfs = deque() #너비 우선 탐색
for r in range(n):
    for c in range(n):
        if houses[r][c] == HOUSE: #집이 있음
            house_count = 1
            bfs.append((r, c))
            houses[r][c] = EMPTY
            while bfs: #인접한 집 확인
                start_r, start_c = bfs.popleft()
                for move_r, move_c in MOVE_DIR:
                    end_r = start_r + move_r
                    end_c = start_c + move_c
                    if end_r < 0 or end_r >= n or end_c < 0 or end_c >= n:
                        continue
                    if houses[end_r][end_c] == HOUSE: #인접한 집이 있음
                        house_count += 1
                        bfs.append((end_r, end_c))
                        houses[end_r][end_c] = EMPTY
            house_counts.append(house_count)

house_counts.sort() #오름차순 정렬
print(len(house_counts), *house_counts, sep="\n") #단지 수와 단지당 집 수