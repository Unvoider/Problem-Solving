import sys
input = sys.stdin.readline

n = int(input())
title = 665
for _ in range(n):
    while True:
        title += 1
        if "666" in str(title):
            break
print(title)

'''
n = int(input())
title = 665
for _ in range(n):
    found = False
    while not found:
        title += 1
        dividend = title
        six_count = 0
        while dividend != 0:
            if dividend % 10 == 6: #6이 세 번 연속되는 수 찾기
                six_count += 1
                if six_count == 3:
                    found = True
            else:
                six_count = 0
            dividend //= 10
print(title)
'''