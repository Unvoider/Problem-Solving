import sys
input = sys.stdin.readline

isbn = input().rstrip()

#total = (a+c+e+g+i+k) + 3(b+d+f+h+j+l)
damaged_idx = -1
total = 0
m = -1
for i, value in enumerate(isbn):
    if value == "*": #손상 인덱스
        damaged_idx = i
    else:
        value = int(value)
        if i == 12: #m 값
            m = value
        else: #0~11번째 값 누적
            total += value if i % 2 == 0 else 3 * value

#m = (10 - total % 10) % 10
if damaged_idx == 12: #m 손상 시 바로 출력
    print((10 - total % 10) % 10)
else:
    weight = 1 if damaged_idx % 2 == 0 else 3 #홀수 번째 가중치
    for i in range(10): #0~9 넣어보고 맞으면 출력
        if(m == (10 - (total + i * weight) % 10) % 10):
            print(i)