import sys
input = sys.stdin.readline

steps_n = int(input())
steps = [int(input()) for _ in range(steps_n)]

max_scores = [0] * steps_n #타뷸레이션
if steps_n >= 1:
    max_scores[0] = steps[0]
if steps_n >= 2:
    max_scores[1] = steps[0] + steps[1]
if steps_n >= 3:
    max_scores[2] = max(steps[0] + steps[2], steps[1] + steps[2])
for i in range(3, steps_n):
    leap_before = steps[i] + max_scores[i - 2]
    no_leap_before = steps[i] + steps[i - 1] + max_scores[i - 3]
    max_scores[i] = max(leap_before, no_leap_before)
print(max_scores[steps_n - 1])