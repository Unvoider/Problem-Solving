import sys
input = sys.stdin.readline

def get_z_order(size, row, col):
    if size == 2: #종료 조건
        return row * 2 + col
    
    half = size >> 1
    #half 제곱 * 사분면 Z 위치 + 재귀 호출
    quad_order = (0 if row < half else 1) * 2 + (0 if col < half else 1)
    recur_order = get_z_order(half, row if row < half else row - half, col if col < half else col - half)
    return half * half * quad_order + recur_order

def main():
    n, r, c = map(int, input().split())
    print(get_z_order(1 << n, r, c))

main()