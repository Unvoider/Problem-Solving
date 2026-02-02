import sys
input = sys.stdin.readline

n = int(input())
last_room = 1
dist = 1
while n > last_room:
    last_room += dist * 6 #마지막 방 번호가 i * 6씩 증가함
    dist += 1
print(dist)