from collections import deque
import sys
input = sys.stdin.readline
write = sys.stdout.write

MOVE_DIR = ((-1, 0), (1, 0), (0, -1), (0, 1))

def count_worms():
    m, n, k = map(int, input().split())

    graph = [[False for _ in range(n)] for _ in range(m)] #격자 그래프
    for _ in range(k):
        x, y = map(int, input().split())
        graph[x][y] = True

    bfs = deque()
    components = 0
    for x in range(m):
        for y in range(n):
            if graph[x][y]: #연결 요소 시작점 찾기
                bfs.append((x, y))
                graph[x][y] = False
                components += 1
            while len(bfs): #너비 우선 탐색
                start_x, start_y = bfs.popleft()
                for move_x, move_y in MOVE_DIR:
                    end_x = start_x + move_x
                    end_y = start_y + move_y
                    if end_x < 0 or end_x >= m or end_y < 0 or end_y >= n:
                        continue
                    if graph[end_x][end_y]:
                        bfs.append((end_x, end_y))
                        graph[end_x][end_y] = False
    write(f"{components}\n") #연결 요소 수

def main():
    t = int(input())
    for _ in range(t):
        count_worms()

main()