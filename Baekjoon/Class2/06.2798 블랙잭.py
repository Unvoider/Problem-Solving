from itertools import combinations
import sys
input = sys.stdin.readline

_, m = map(int, input().split())
nums = list(map(int, input().split()))
closest = 0
for picks in combinations(nums, 3):
    total = sum(picks)
    if total <= m and total > closest:
        closest = total
        if closest == m: #같으면 바로 종료
            break
print(closest)

''' 3중 for문 사용
import sys
input = sys.stdin.readline

def find_closest(nums, n, m):
    closest = 0
    for i in range(n - 2):
        for j in range(i + 1, n - 1):
            for k in range(j + 1, n):
                total = nums[i] + nums[j] + nums[k]
                if total <= m and total > closest:
                    closest = total
                    if closest == m: #같으면 바로 종료
                        return closest
    return closest

def main():
    n, m = map(int, input().split())
    nums = list(map(int, input().split()))
    print(find_closest(nums, n, m))

main()
'''