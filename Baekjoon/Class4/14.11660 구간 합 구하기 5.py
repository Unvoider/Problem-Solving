import sys
input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
out = []

acc = [[0] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1): #누적 합
    for j in range(1, n + 1):
        acc[i][j] = board[i - 1][j - 1] + acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1]

for _ in range(m): #출력
    x1, y1, x2, y2 = map(int, input().split())
    out.append(str(acc[x2][y2] + acc[x1 - 1][y1 - 1] - acc[x2][y1 - 1] - acc[x1 - 1][y2]))

print("\n".join(out))