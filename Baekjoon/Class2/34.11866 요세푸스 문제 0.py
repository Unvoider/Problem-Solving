import sys
input = sys.stdin.readline

n, k = map(int, input().split())
people = list(range(1, n + 1))
out = []

idx = 0
while people:
    idx = (idx + k - 1) % len(people) #k - 1번 이동
    out.append(str(people.pop(idx))) #k번째 사람
print(f"<{", ".join(out)}>")

''' deque rotate 사용
from collections import deque
import sys
input = sys.stdin.readline

n, k = map(int, input().split())
people = deque(range(1, n + 1))
out = []

while people:
    people.rotate(-(k - 1)) #k - 1번 rotate left
    out.append(people.popleft()) #k번째 사람
print(f"<{", ".join(out)}>")
'''