import sys
input = sys.stdin.readline

nums = set()
for _ in range(0, 10):
    nums.add(int(input()) % 42)
#nums = {int(input()) % 42 for _ in range(0, 10)}
print(len(nums))