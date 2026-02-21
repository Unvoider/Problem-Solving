import sys
input = sys.stdin.readline

def count_cut_wire(length, wires): #잘린 선 개수
    return sum(wire // length for wire in wires)

def max_cut_length(required, wires):
    answer = 0
    left = 1
    right = max(wires)
    while left <= right:
        middle = (left + right) // 2
        if count_cut_wire(middle, wires) >= required: #더 길게 자를 수도 있음
            left = middle + 1
            answer = middle
        else: #더 짧게 잘라야 함
            right = middle - 1
    return answer

def main():
    k, n = map(int, input().split())
    wires = [int(input()) for _ in range(k)]
    print(max_cut_length(n, wires)) 

main()