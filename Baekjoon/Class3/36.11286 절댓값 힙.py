import heapq
import sys
input = sys.stdin.readline

n = int(input())
out = []

q = [] #최소 힙
for _ in range(n):
    x = int(input())
    if x == 0: #팝
        if not q: #빔
            out.append("0")
        else:
            out.append(str(heapq.heappop(q)[1]))
    else: #푸시
        heapq.heappush(q, (abs(x), x))
print("\n".join(out))