import sys
input = sys.stdin.readline

h, m = map(int, input().split())
m -= 45
if m < 0:
	m += 60
	h = (h - 1) % 24
print(h, m)