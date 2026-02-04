import sys
input = sys.stdin.readline
write = sys.stdout.write

NUM_RANGE = 10001

n = int(input())

num_counts = [0] * NUM_RANGE
for _ in range(n): #계수 정렬
    num = int(input())
    num_counts[num] += 1
for i in range(1, NUM_RANGE): #출력
    if num_counts[i] != 0:
        for _ in range(num_counts[i]):
            write(f"{str(i)}\n")