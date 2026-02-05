import sys
input = sys.stdin.readline

n = int(input())
five_count = 0

#곱해진 10(2 * 5의 쌍) 개수 세기
#소인수분해 시 항상 2보다 5가 적으므로 5의 개수만 세면 됨
i = 5
while i <= n:
    five_count += n // i
    i *= 5
print(five_count)