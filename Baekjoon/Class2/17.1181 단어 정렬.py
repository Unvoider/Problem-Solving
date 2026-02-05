import sys
input = sys.stdin.readline

n = int(input())
words = set()
for _ in range(n):
    words.add(input().rstrip())
words = list(words)
words.sort()
words.sort(key = len)
print("\n".join(words))