from collections import deque
import sys
input = sys.stdin.readline

BOARD_SIZE = 100

def count_rolls(ladders_and_snakes):
    roll_counts = [0] * (BOARD_SIZE + 1) #암시적 그래프
    bfs = deque([1]) #시작 위치
    while bfs:
        start = bfs.popleft()
        for move in range(1, 7):
            end = start + move
            if end < BOARD_SIZE and ladders_and_snakes[end] != 0: #사다리 뱀 타기
                end = ladders_and_snakes[end]
            if end <= 0 or end > BOARD_SIZE: #경계 검사
                continue
            if roll_counts[end] == 0: #이동
                roll_counts[end] = roll_counts[start] + 1
                if end == BOARD_SIZE:
                    return roll_counts[end]
                bfs.append(end)
    return -1


def main():     
    n, m = map(int, input().split())

    ladders_and_snakes = [0] * BOARD_SIZE
    for _ in range(n + m):
        start, end = map(int, input().split())
        ladders_and_snakes[start] = end

    print(count_rolls(ladders_and_snakes))

main()