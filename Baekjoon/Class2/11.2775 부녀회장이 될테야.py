#반복 동적 프로그래밍
import sys
input = sys.stdin.readline
write = sys.stdout.write

t = int(input())
apt = [[x for x in range(1, 16)] for _ in range(15)] #타뷸레이션

for i in range(1, 15): #전체 계산
    for j in range(1, 15):
        apt[i][j] = apt[i - 1][j] + apt[i][j - 1]; #아랫집 + 왼쪽 집

for _ in range(t):
    k = int(input())
    n = int(input())
    write(f"{apt[k][n - 1]}\n")

''' 재귀 동적 프로그래밍
import sys
input = sys.stdin.readline
write = sys.stdout.write

apt = [[0] * 15 for _ in range(15)] #메모이제이션
for i in range(15):
    apt[0][i] = i + 1; #0층 초기화
    apt[i][0] = 1; #1호 초기화

def count_people(floor, room):
    #0층/1호 고정 값
    if floor == 0: return room
    if room == 1: return 1

    #저장된 값 반환
    count = apt[floor][room]
    if count != 0: return count

    #없으면 계산
    count = count_people(floor - 1, room) + count_people(floor, room - 1)
    apt[floor][room] = count
    return count

def main():
    t = int(input())
    for _ in range(t):
        k = int(input())
        n = int(input())
        write(f"{count_people(k, n)}\n")

main()
'''