import sys
input = sys.stdin.readline

n = int(input())
nums = []
for i in range(1, n + 1):
    nums.append(i)
print("\n".join(map(str, nums)))

'''
n = int(input())
print("\n".join((str(i) for i in range(1, n + 1))))
'''