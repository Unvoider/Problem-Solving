import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
maxLengths = [1] * n
maxLength = 1

for i in range(n):
    for j in range(i): #각 도착점의 최대 길이 찾기
        if a[i] > a[j]:
            maxLengths[i] = max(maxLengths[i], maxLengths[j] + 1)
    if maxLengths[i] > maxLength: #전체 도착점 중 최대 길이 찾기
        maxLength = max(maxLength, maxLengths[i])

print(maxLength)