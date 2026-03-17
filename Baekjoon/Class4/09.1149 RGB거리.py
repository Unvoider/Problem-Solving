import sys
input = sys.stdin.readline

n = int(input())
r, g, b = map(int, input().split())

for i in range(1, n):
    prev_r, prev_g, prev_b = r, g, b

    r, g, b = map(int, input().split())
    r += min(prev_g, prev_b) #다른 색 중 최솟값 더하기
    g += min(prev_r, prev_b)
    b += min(prev_r, prev_g)

print(min(r, g, b))

''' 확장 가능
import sys
input = sys.stdin.readline

MAX_COST = 10000000

n = int(input())
colors = list(map(int, input().split()))

for i in range(1, n):
    prev_colors = colors

    colors = list(map(int, input().split()))
    colors = [colors[j] + min([
        #다른 색 중 최솟값 더하기
        prev_colors[k] if j != k else MAX_COST for k in range(0, len(colors))
        ]) for j in range(len(colors))]

print(min(colors))
'''