from collections import deque
import sys
input = sys.stdin.readline
write = sys.stdout.write

MOVE_DIR = ((-1, 0), (1, 0), (0, -1), (0, 1))

def count_worms():
    m, n, k = map(int, input().split())

    graph = [[False for _ in range(n)] for _ in range(m)] #격자 그래프
    for _ in range(k):
        r, c = map(int, input().split())
        graph[r][c] = True

    bfs = deque()
    components = 0
    for r in range(m):
        for c in range(n):
            if graph[r][c]: #연결 요소 시작점 찾기
                bfs.append((r, c))
                graph[r][c] = False
                components += 1
            while len(bfs): #너비 우선 탐색
                start_r, start_c = bfs.popleft()
                for move_r, move_c in MOVE_DIR:
                    end_r = start_r + move_r
                    end_c = start_c + move_c
                    if end_r < 0 or end_r >= m or end_c < 0 or end_c >= n:
                        continue
                    if graph[end_r][end_c]:
                        bfs.append((end_r, end_c))
                        graph[end_r][end_c] = False
    write(f"{components}\n") #연결 요소 수

def main():
    t = int(input())
    for _ in range(t):
        count_worms()

main()