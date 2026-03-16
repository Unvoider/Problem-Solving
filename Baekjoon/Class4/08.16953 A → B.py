import sys
input = sys.stdin.readline

a, b = map(int, input().split())
depth = 1

while b > a:
    if b % 2 == 0: #2를 곱한다
        b >>= 1
    elif b % 10 == 1: #1을 수의 가장 오른쪽에 추가한다
        b //= 10
    else: #미리 종료
        break
    depth += 1

print(depth if a == b else -1)