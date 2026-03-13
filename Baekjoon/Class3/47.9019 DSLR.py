#양방향 BFS
from collections import deque
import sys
input = sys.stdin.readline
write = sys.stdout.write

MAX_NUM = 9999
BEGINNING = -1
A_OPERATIONS = "DSLR"
B_OPERATIONS = "DDSLR"

#미리 DSLR 계산
A_DSLR = [(
    (2 * n) % 10000,
    MAX_NUM if n == 0 else n - 1,
    (n * 10) % 10000 + n // 1000, #shift left + carry
    (n // 10) + (n % 10) * 1000 #shift right + carry * 1000
    ) for n in range(10000)]
B_DSLR = [(
    n // 2,
    (n + 10000) // 2,
    0 if n == 9999 else n + 1,
    (n // 10) + (n % 10) * 1000, #shift right + carry * 1000
    (n * 10) % 10000 + n // 1000 #shift left + carry
    ) for n in range(10000)]

def print_traces(meeting_point, a_operations, b_operations):
    a_trace = []
    cur = a_operations[meeting_point] #A 역추적
    while cur[1] != BEGINNING:
        a_trace.append(cur[0])
        cur = a_operations[cur[1]]

    b_trace = []
    cur = b_operations[meeting_point] #B 역추적
    while cur[1] != BEGINNING:
        b_trace.append(cur[0])
        cur = b_operations[cur[1]]
    
    write(f"{"".join(a_trace[::-1])}{"".join(b_trace)}\n")

def find_meeting_point(start, ends, bfs, operations, other_operations):
    for symbol, end in ends:
        if operations[end] is None: #연산자 저장
            bfs.append(end)
            operations[end] = (symbol, start)
        if other_operations[end] is not None: #반대편과 만남
            return end
    return None

def run_register():
    a, b = map(int, input().split())
    if a == b:
        write("\n")
        return

    a_operations = [None] * (MAX_NUM + 1) #(operation, prev_index)
    b_operations = [None] * (MAX_NUM + 1)
    a_bfs = deque([a]) #너비 우선 탐색
    b_bfs = deque([b])
    a_operations[a] = ("", BEGINNING)
    b_operations[b] = ("", BEGINNING)

    while True:
        for _ in range(len(a_bfs)): #한 레벨씩
            #정방향 DSLR 연산 저장
            start = a_bfs.popleft()
            ends = [(A_OPERATIONS[i], A_DSLR[start][i]) for i in range(4)]

            #정방향 탐색
            meeting_point = find_meeting_point(start, ends, a_bfs, a_operations, b_operations)
            if meeting_point is not None:
                print_traces(meeting_point, a_operations, b_operations)
                return

        for _ in range(len(b_bfs)):
            #역방향 DSLR 연산 저장
            start = b_bfs.popleft()
            ends = [(B_OPERATIONS[i], B_DSLR[start][i]) for i in (range(0, 5) if start % 2 == 0 else range(2, 5))]

            #역방향 탐색
            meeting_point = find_meeting_point(start, ends, b_bfs, b_operations, a_operations)
            if meeting_point is not None:
                print_traces(meeting_point, a_operations, b_operations)
                return

def main():
    t = int(input())
    for _ in range(t):
        run_register()

main()

''' 단방향 BFS
from collections import deque
import sys
input = sys.stdin.readline
write = sys.stdout.write

MAX_NUM = 9999
NOT_VISITED = -1
BEGINNING = -2
OPERATIONS = "DSLR"

#미리 DSLR 계산
DSLR = [(
    (2 * n) % 10000,
    MAX_NUM if n == 0 else n - 1,
    (n * 10) % 10000 + n // 1000, #shift left + carry
    (n // 10) + (n % 10) * 1000 #shift right + carry * 1000
    ) for n in range(10000)]

def run_register():
    a, b = map(int, input().split())

    operations = [""] * (MAX_NUM + 1)
    prev_indexes = [NOT_VISITED] * (MAX_NUM + 1)
    bfs = deque([a]) #너비 우선 탐색
    prev_indexes[a] = BEGINNING
    while True:
        start = bfs.popleft()
        for i in range(len(OPERATIONS)):
            end = DSLR[start][i]
            if prev_indexes[end] == NOT_VISITED: #연산자 저장
                bfs.append(end)
                operations[end] = OPERATIONS[i]
                prev_indexes[end] = start
            if end == b: #B 도착
                out = [operations[end]]
                prev_index = prev_indexes[end] #역추적
                while prev_index != BEGINNING:
                    out.append(operations[prev_index])
                    prev_index = prev_indexes[prev_index]
                write(f"{"".join(out[::-1])}\n")
                return

def main():
    t = int(input())
    for _ in range(t):
        run_register()

main()
'''