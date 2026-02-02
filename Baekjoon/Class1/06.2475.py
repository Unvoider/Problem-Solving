import sys
input = sys.stdin.readline

nums = map(int, input().split())
total = 0
for num in nums:
    total += num * num
print(total % 10)

'''
nums = map(int, input().split())
print(sum([num * num for num in nums]) % 10)
'''