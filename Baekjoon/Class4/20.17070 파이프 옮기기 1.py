import sys
input = sys.stdin.readline

'''
가로 도착
000 000
000 000
pp0 0pp

000 000
p00 000
0p0 0pp

세로 도착
00p 000
00p 00p
000 00p

0p0 000
00p 00p
000 00p

대각선 도착
000 000
pp0 0p0
000 00p

0p0 000
0p0 0p0
000 00p

p00 000
0p0 0p0
000 00p
'''

n = int(input())

#벽 위치 기록
walls = [[0] * (n + 1)] + [[0, *map(int, input().split(" "))] for _ in range(n)]

#[행][열][파이프 방향(가로: 0, 세로: 1, 대각선: 2)]
moves = [[[0, 0, 0] for _ in range(n + 1)] for _ in range(n + 1)]
moves[1][2][0] = 1

for c in range(3, n + 1): #첫 줄
    if walls[1][c] == 0:
        moves[1][c][0] = moves[1][c - 1][0] #가로 도착

for r in range(2, n + 1): #나머지 줄
    for c in range(2, n + 1):
        if walls[r][c] == 0:
            moves[r][c][0] = moves[r][c - 1][0] + moves[r][c - 1][2]; #가로 도착
            moves[r][c][1] = moves[r - 1][c][1] + moves[r - 1][c][2]; #세로 도착
            if walls[r - 1][c] == 0 and walls[r][c - 1] == 0: #대각선 도착
                moves[r][c][2] = sum(moves[r - 1][c - 1])

print(sum(moves[n][n]))