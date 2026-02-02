import sys
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    score = 0
    total = 0
    string = input().rstrip()
    for ch in string:
        if ch == "O":
            score += 1
            total += score
        else:
            score = 0
    print(total)