import sys
input = sys.stdin.readline

n = int(input())

triangle = [list(map(int, input().split())) for _ in range(n)] #삼각형 입력
for i in range(n - 1, 0, -1): #맨아래 레벨부터 더 큰 자식 누적하기
    for j in range(0, i):
        triangle[i - 1][j] += max(triangle[i][j], triangle[i][j + 1])

print(triangle[0][0])