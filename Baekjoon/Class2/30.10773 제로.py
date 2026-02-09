import sys
input = sys.stdin.readline

k = int(input())
nums = []

for _ in range(k):
    num = int(input())
    if num == 0:
        nums.pop() #0이면 pop
    else:
        nums.append(num)

total = 0
while len(nums) != 0:
    total += nums.pop()
print(total)