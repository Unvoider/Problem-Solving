import sys
input = sys.stdin.readline

min = 10000001
max = -10000001
_ = int(input())
for num in list(map(int, input().split())):
    if num < min: min = num
    if num > max: max = num
print(min, max)

'''
_ = input()
nums = list(map(int, input().split()))
print(min(nums), max(nums))
'''