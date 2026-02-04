import sys
input = sys.stdin.readline

while True:
    a, b, c = sorted(map(int, input().split()))
    if a == 0 and b == 0 and c == 0:
        break
    if a * a + b * b == c * c:
        print("right")
    else: print("wrong")