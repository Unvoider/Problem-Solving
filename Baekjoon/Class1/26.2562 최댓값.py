import sys
input = sys.stdin.readline

max = -1
max_index = -1
for i in range(1, 10):
    num = int(input())
    if num > max:
        max = num
        max_index = i
print(max)
print(max_index)