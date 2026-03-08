#경계 패딩
from collections import deque
import sys
input = sys.stdin.readline

MOVE_DIR = ((-1, 0), (1, 0), (0, -1), (0, 1))

n, m = map(int, input().split())

bfs = deque()
campus = [list("X" * (m + 2))] #위 패딩
for r in range(1, n + 1):
    row = input().rstrip()
    campus.append(list("X" + row + "X")) #좌우 패딩
    c = row.find("I") + 1 #시작점 찾기
    if c != 0:
        bfs.append((r, c))
        campus[r][c] = "X" #방문 처리
campus.append(list("X" * (m + 2))) #아래 패딩

people = 0 #주변 사람 찾기
while bfs:
    start_r, start_c = bfs.popleft()
    for move_r, move_c in MOVE_DIR: #모든 방향에 대해
        end_r = start_r + move_r
        end_c = start_c + move_c
        target = campus[end_r][end_c]
        if target == "X":
            continue
        if target == "P": #사람 발견
            people += 1
        bfs.append((end_r, end_c)) #빈 공간으로 이동
        campus[end_r][end_c] = "X" #방문 처리

if people == 0:
    print("TT")
else:
    print(people)

''' 경계 확인
from collections import deque
import sys
input = sys.stdin.readline

MOVE_DIR = ((-1, 0), (1, 0), (0, -1), (0, 1))

n, m = map(int, input().split())

bfs = deque()
campus = []
for r in range(n):
    row = input().rstrip()
    campus.append(list(row))
    c = row.find("I") #시작점 찾기
    if c != -1:
        bfs.append((r, c))
        campus[r][c] = "X" #방문 처리

people = 0 #주변 사람 찾기
while bfs:
    start_r, start_c = bfs.popleft()
    for move_r, move_c in MOVE_DIR: #모든 방향에 대해
        end_r = start_r + move_r
        end_c = start_c + move_c
        if end_r < 0 or end_r >= n or end_c < 0 or end_c >= m: #경계 확인
            continue
        target = campus[end_r][end_c]
        if target == "X":
            continue
        if target == "P": #사람 발견
            people += 1
        bfs.append((end_r, end_c)) #빈 공간으로 이동
        campus[end_r][end_c] = "X" #방문 처리

if people == 0:
    print("TT")
else:
    print(people)
'''