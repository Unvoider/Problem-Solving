from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
num_deque = deque([0]) #top 접근을 위한 더미 데이터
out = []

num_to_push = 1
for _ in range(n): #n번 pop
    num_to_pop = int(input())
    while num_deque[-1] < num_to_pop: #pop할 숫자가 없으면
        num_deque.append(num_to_push) #push하기
        num_to_push += 1
        out.append("+")
    if num_deque[-1] > num_to_pop: #top이 pop할 숫자 초과(실패)
        out = ["NO"]
        break
    num_deque.pop() #pop할 숫자 찾음
    out.append("-")

print("\n".join(out))