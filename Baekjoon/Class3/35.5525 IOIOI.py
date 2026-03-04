import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
s = input().rstrip()

p_count = 0
i = 0
while i < m - n * 2:
    if s[i] == "I": #시작 문자 찾기
        oi_count = 0
        while i + 2 < m: #뒤에 있는 문자 두 개 확인
            if s[i + 1 : i + 3] == "OI":
                i += 2
                oi_count += 1
                if oi_count >= n:
                    p_count += 1
            else:
                break
    i += 1

print(p_count)