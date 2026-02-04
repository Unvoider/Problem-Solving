import sys
input = sys.stdin.readline

t = int(input())
apt = [[x for x in range(1, 16)] for _ in range(15)] #타뷸레이션

for i in range(1, 15): #전체 계산
    for j in range(1, 15):
        apt[i][j] = apt[i - 1][j] + apt[i][j - 1]; #아랫집 + 왼쪽 집

for _ in range(t):
    k = int(input())
    n = int(input())
    print(apt[k][n - 1])