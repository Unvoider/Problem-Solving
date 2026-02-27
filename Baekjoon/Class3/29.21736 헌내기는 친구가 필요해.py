#경계 패딩
from collections import deque
import sys
input = sys.stdin.readline

MOVE_DIR = ((-1, 0), (1, 0), (0, -1), (0, 1))

n, m = map(int, input().split())

bfs = deque()
campus = [list("X" * (m + 2))] #위 패딩
for x in range(1, n + 1):
    row = input().rstrip()
    campus.append(list("X" + row + "X")) #좌우 패딩
    y = row.find("I") + 1 #시작점 찾기
    if y != 0:
        bfs.append((x, y))
        campus[x][y] = "X" #방문 처리
campus.append(list("X" * (m + 2))) #아래 패딩

people = 0 #주변 사람 찾기
while bfs:
    start_x, start_y = bfs.popleft()
    for move_x, move_y in MOVE_DIR: #모든 방향에 대해
        end_x = start_x + move_x
        end_y = start_y + move_y
        target = campus[end_x][end_y]
        if target == "X":
            continue
        if target == "P": #사람 발견
            people += 1
        bfs.append((end_x, end_y)) #빈 공간으로 이동
        campus[end_x][end_y] = "X" #방문 처리

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
for x in range(n):
    row = input().rstrip()
    campus.append(list(row))
    y = row.find("I") #시작점 찾기
    if y != -1:
        bfs.append((x, y))
        campus[x][y] = "X" #방문 처리

people = 0 #주변 사람 찾기
while bfs:
    start_x, start_y = bfs.popleft()
    for move_x, move_y in MOVE_DIR: #모든 방향에 대해
        end_x = start_x + move_x
        end_y = start_y + move_y
        if end_x < 0 or end_x >= n or end_y < 0 or end_y >= m: #경계 확인
            continue
        target = campus[end_x][end_y]
        if target == "X":
            continue
        if target == "P": #사람 발견
            people += 1
        bfs.append((end_x, end_y)) #빈 공간으로 이동
        campus[end_x][end_y] = "X" #방문 처리

if people == 0:
    print("TT")
else:
    print(people)
'''