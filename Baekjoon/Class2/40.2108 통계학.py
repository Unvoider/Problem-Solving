from collections import Counter
import sys
input = sys.stdin.readline

n = int(input())
nums = sorted([int(input()) for _ in range(n)]) #정렬
total = sum(nums) #합계
modes = Counter(nums).most_common(2) #[(값, 빈도), ...]
mode = 0
if len(modes) == 1 or modes[0][1] != modes[1][1]:
    mode = modes[0][0]
else:
    mode = modes[1][0]

print(round(total / n)) #산술평균
print(nums[n // 2]) #중앙값
print(mode) #최빈값
print(nums[n - 1] - nums[0]) #범위