from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
cards = deque(range(1, n + 1))

while len(cards) > 1:
    cards.popleft() #맨 위 제거
    cards.append(cards.popleft()) #맨 위 -> 맨 아래
print(cards[0])