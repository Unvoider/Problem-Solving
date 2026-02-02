import sys
input = sys.stdin.readline

n = int(input())
scores = map(int, input().split())
m = 0
total = 0
for score in scores:
    total += score
    if score > m:
        m = score
print((total / m * 100) / n)

'''
n = int(input())
scores = list(map(int, input().split()))
print((sum(scores) / max(scores) * 100) / n)
'''