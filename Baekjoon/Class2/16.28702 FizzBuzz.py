import sys
input = sys.stdin.readline

for i in range(3):
    value = input()
    try: #숫자인 입력 찾기
        value = int(value)
    except ValueError:
        continue
    value = value + 3 - i #다음 숫자
    if value % 15 == 0: print("FizzBuzz") #출력
    elif value % 3 == 0: print("Fizz")
    elif value % 5 == 0: print("Buzz")
    else: print(value)
    break