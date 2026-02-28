import sys
input = sys.stdin.readline

n = int(input())
sn = list(map(int, input().split())) #과일 순서

max_fruit = 0
fruit_types = 0 #과일 종류
fruit_counts = [0] * 10 #과일 종류별 개수

front = 0
rear = 0
while rear < n:
    rear_fruit = sn[rear] #과일 추가
    rear += 1
    fruit_counts[rear_fruit] += 1
    if fruit_counts[rear_fruit] == 1:
        fruit_types += 1
    while fruit_types > 2: #두 종류보다 많으면 과일 제거
        front_fruit = sn[front]
        front += 1
        fruit_counts[front_fruit] -= 1
        if fruit_counts[front_fruit] == 0:
            fruit_types -= 1
    max_fruit = max(max_fruit, rear - front) #최대 개수 업데이트
print(max_fruit)