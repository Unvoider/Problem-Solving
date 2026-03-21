import sys
input = sys.stdin.readline

t = int(input())
out = []

for _ in range(t):
    n = int(input())
    scores = [list(map(int, input().split())) for _ in range(2)]

    if n != 1:
        scores[0][1] += scores[1][0] #위 뗌
        scores[1][1] += scores[0][0] #아래 뗌
        for i in range(2, n):
            scores[0][i] += max(scores[1][i - 1], scores[1][i - 2]) #위 뗌
            scores[1][i] += max(scores[0][i - 1], scores[0][i - 2]) #아래 뗌
    out.append(str(max(scores[0][n - 1], scores[1][n - 1])))

print("\n".join(out))