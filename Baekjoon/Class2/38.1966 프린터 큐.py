from collections import deque
import sys
input = sys.stdin.readline
write = sys.stdout.write

def run_printer():
    _, m = map(int, input().split())
    priorities = list(map(int, input().rstrip().split())) #우선순위
    printer_queue = deque(enumerate(priorities)) #(인덱스, 우선순위)
    priorities.sort(reverse=True) #우선순위 내림차순 정렬

    #우선순위가 높은 것부터 출력
    order = 0 #출력 순서
    while True:
        front_idx, front_priority = printer_queue.popleft()
        if front_priority == priorities[order]: #해당 우선순위 찾음
            if front_idx == m: #출력
                write(f"{order + 1}\n")
                break
            order += 1
        else: #해당 우선순위 못 찾음
            printer_queue.append((front_idx, front_priority)) #회전

def main():
    test_case = int(input())
    for _ in range(test_case):
        run_printer()

main()