import sys
input = sys.stdin.readline

n = int(input())
weights, heights = [0] * n, [0] * n
for i in range(n):
    weights[i], heights[i] = map(int, input().split(" "))

ranks = [1] * n #i의 등수
for i in range(n):
    for j in range(n):
        if weights[i] < weights[j] and heights[i] < heights[j]:
            ranks[i] += 1

print(" ".join(map(str, ranks)))