import sys
input = sys.stdin.readline

test_case = int(input())
out = []
for _ in range(test_case):
    n = int(input())

    clothes = {} #옷의 종류
    for _ in range(n):
        _, type = input().split()
        clothes[type] = clothes.get(type, 0) + 1
    
    cases = 1 #옷을 입는 경우의 수
    for val in clothes.values():
        cases *= val + 1
    out.append(str(cases - 1))

print("\n".join(out))