from collections import deque
import sys
input = sys.stdin.readline
write = sys.stdout.write

def ac():
    p = input().rstrip()
    input()
    xn_str = input().rstrip()
    if xn_str == "[]":
        xn = deque()
    else:
        xn = deque(xn_str[1 : -1].split(",")) #파싱

    is_front = True #포인터 위치
    for command in p:
        if command == "R": #덱 뒤집기
            is_front = not is_front
        else: #팝
            if not xn: #비었음
                write("error\n")
                return
            if is_front:
                xn.popleft()
            else:
                xn.pop()
    
    if not is_front:
        xn.reverse()
    write(f"[{",".join(xn)}]\n") #출력

def main():
    t = int(input())
    for _ in range(t):
         ac()

main()