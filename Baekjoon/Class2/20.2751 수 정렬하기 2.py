import sys
input = sys.stdin.read
write = sys.stdout.write

nums = list(map(int, input().split()[1:]))
nums.sort()
write("\n".join(map(str, nums)))