import sys
input = sys.stdin.readline

n = int(input())
out = 0
#999999의 각 자리를 모두 더해도 기껏해야 54가 나오므로 N - 54부터 시작함
for i in range(max(n - 54, 0), n):
    num = i
    total = i
    while num != 0:
        total += num % 10 #각 자리 수 더하기
        num //= 10
    if total == n: #찾음
        out = i
        break
print(out)

''' str으로 변환하여 각 자리 수 더하기
n = int(input())
out = 0
#999999의 각 자리를 모두 더해도 기껏해야 54가 나오므로 N - 54부터 시작함
for i in range(max(n - 54, 0), n):
    if sum(map(int, str(i))) + i == n:
        out = i
        break
print(out)
'''