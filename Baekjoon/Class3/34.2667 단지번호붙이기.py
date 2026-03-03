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
for x in range(n):
    for y in range(n):
        if houses[x][y] == HOUSE: #집이 있음
            house_count = 1
            bfs.append((x, y))
            houses[x][y] = EMPTY
            while bfs: #인접한 집 확인
                start_x, start_y = bfs.popleft()
                for move_x, move_y in MOVE_DIR:
                    end_x = start_x + move_x
                    end_y = start_y + move_y
                    if end_x < 0 or end_x >= n or end_y < 0 or end_y >= n:
                        continue
                    if houses[end_x][end_y] == HOUSE: #인접한 집이 있음
                        house_count += 1
                        bfs.append((end_x, end_y))
                        houses[end_x][end_y] = EMPTY
            house_counts.append(house_count)

house_counts.sort() #오름차순 정렬
print(len(house_counts), *house_counts, sep="\n") #단지 수와 단지당 집 수