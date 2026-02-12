import sys
input = sys.stdin.readline

#나머지 연산
def count_paint(board, row, col): #색칠해야 하는 칸 세기
    count = 0
    for i in range(row, row + 8):
        for j in range(col, col + 8):
            if (i + j) % 2 == 0 and board[i][j] == "B": #잘못 색칠된 검정
                count += 1
            elif (i + j) % 2 == 1 and board[i][j] == "W": #잘못 색칠된 하양
                count += 1
    return count

''' 체스판 생성
def count_paint(board, row, col): #색칠해야 하는 칸 세기
    row_first = "W" #흰색으로 시작하는 체스 보드
    count = 0
    for i in range(8):
        cur = row_first
        for j in range(8):
            if board[i + row][j + col] != cur:
                count += 1
            cur = "B" if cur == "W" else "W"
        row_first = "B" if row_first == "W" else "W"
    return count
'''

''' 체스판 선언
CHESS_BOARD = [ #흰색으로 시작하는 체스 보드
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW"
]
def count_paint(board, row, col): #색칠해야 하는 칸 세기
    count = 0
    for i in range(8):
        for j in range(8):
            if board[i + row][j + col] != CHESS_BOARD[i][j]:
                count += 1
    return count
'''

def main():
    n, m = map(int, input().split())
    board = [input() for _ in range(n)]
    min_count = 64
    for row in range(n - 7):
        for col in range(m - 7):
            count = count_paint(board, row, col)
            #흰색으로 시작할 때 색칠할 칸, 반전한 경우, 이전 최소값 중 최소값 선택
            min_count = min(count, 64 - count, min_count)
    print(min_count)

main()