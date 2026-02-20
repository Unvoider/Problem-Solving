import sys
input = sys.stdin.readline

expr = input().rstrip().split("-")
total = sum(map(int, expr[0].split("+"))) #"-"가 나오기 전까지 더하기
for i in range(1, len(expr)): #"-"가 나오면 빼기
    total -= sum(map(int, expr[i].split("+")))
print(total)