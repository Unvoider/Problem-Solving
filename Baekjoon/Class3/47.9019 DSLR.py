from collections import deque
import sys
input = sys.stdin.readline
write = sys.stdout.write

MAX_NUM = 9999
NOT_VISITED = -1
BEGINNING = -2
SYMBOLS = "DSLR"

#미리 DSLR 계산
D_LIST = [(2 * n) % 10000 for n in range(10000)]
S_LIST = [MAX_NUM if n == 0 else n - 1 for n in range(10000)]
L_LIST = [(n * 10) % 10000 + n // 1000 for n in range(10000)] #shift left + carry
R_LIST = [(n // 10) + (n % 10) * 1000 for n in range(10000)] #shift right + carry * 1000
DSLR = (D_LIST, S_LIST, L_LIST, R_LIST)

def run_register():
    dslr = DSLR
    a, b = map(int, input().split())

    operations = [""] * (MAX_NUM + 1)
    prev_indexes = [NOT_VISITED] * (MAX_NUM + 1)
    bfs = deque([a]) #너비 우선 탐색
    prev_indexes[a] = BEGINNING
    while bfs:
        start = bfs.popleft()
        for i in range(len(dslr)):
            end = dslr[i][start]
            if prev_indexes[end] == NOT_VISITED: #연산자 저장
                bfs.append(end)
                operations[end] = SYMBOLS[i]
                prev_indexes[end] = start
            if end == b: #B 도착
                trace = [operations[end]]
                prev_index = prev_indexes[end] #역추적
                while prev_index != BEGINNING:
                    trace.append(operations[prev_index])
                    prev_index = prev_indexes[prev_index]
                write(f"{"".join(trace[::-1])}\n")
                return

def main():
    t = int(input())
    for _ in range(t):
        run_register()

main()