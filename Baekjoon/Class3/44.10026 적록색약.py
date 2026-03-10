from collections import deque
import sys
input = sys.stdin.readline

MOVE_DIR = ((-1, 0), (1, 0), (0, -1), (0, 1))

class CountColorArea:
    def __init__(self, colors, is_equal):
        self._area_count = 0
        n = len(colors)
        visited = [[False] * n for _ in range(n)]
        for r in range(n):
            for c in range(n):
                if not visited[r][c]: #처음 발견한 색
                    current_color = colors[r][c]
                    self._area_count += 1 #개수 세기
                    bfs = deque([(r, c)]) #너비 우선 탐색
                    visited[r][c] = True
                    while bfs:
                        start_r, start_c = bfs.popleft()
                        for move_r, move_c in MOVE_DIR:
                            end_r = start_r + move_r
                            end_c = start_c + move_c
                            if end_r < 0 or end_r >= n or end_c < 0 or end_c >= n:
                                continue
                            #주변 같은 색 발견
                            if not visited[end_r][end_c] and is_equal(current_color, colors[end_r][end_c]):
                                bfs.append((end_r, end_c))
                                visited[end_r][end_c] = True
    @property
    def area_count(self):
        return self._area_count

n = int(input())
colors = [input().rstrip() for _ in range(n)] #격자 그래프
print(CountColorArea(colors,
    lambda color1, color2: #일반 비교 함수
        color1 == color2)
    .area_count, end=' ')
print(CountColorArea(colors,
    lambda color1, color2: #색맹 비교 함수
        color1 == color2 or color1 in "RG" and color2 in "RG")
    .area_count)