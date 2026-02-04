import sys
input = sys.stdin.readline

_ = int(input())
nums = list(map(int, input().rstrip()))
print(sum(nums))

'''
_ = int(input())
nums = list(map(int, input().rstrip()))
total = 0
for num in nums:
    total += num
print(total)
'''