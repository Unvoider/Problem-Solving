# Counter 사용
from collections import Counter
import sys
input = sys.stdin.readline

_ = input()
counts = Counter(map(int, input().split()))
_ = input()
targets = list(map(int, input().split()))

print(*([counts[target] for target in targets]))

''' dict 사용
import sys
input = sys.stdin.readline
write = sys.stdout.write

_ = input()
cards = map(int, input().split())
_ = input()
targets = list(map(int, input().split()))
counts = {}

for card in cards:
    counts[card] = counts.get(card, 0) + 1 #개수 세기
for target in targets:
    #dict의 접근 시간 O(1)
    write(f"{counts.get(target, 0)} ")
'''

''' 이진 탐색
import bisect
import sys
input = sys.stdin.readline
write = sys.stdout.write

_ = input()
cards = sorted(map(int, input().split())) #정렬
cards_len = len(cards)
_ = input()
targets = list(map(int, input().split()))

for target in targets:
    #시작과 끝 인덱스 이진 탐색 O(logn)
    target_left = bisect.bisect_left(cards, target)
    if target_left >= cards_len: #시작 인덱스 없음
        write("0 ")
        continue
    target_right = bisect.bisect_right(cards, target)
    write(f"{target_right - target_left} ")
'''

''' 이진 탐색 구현
import sys
input = sys.stdin.readline
write = sys.stdout.write

def bin_search_lower_bound(li, target):
    lower_bound = -1
    left = 0
    right = len(li) - 1
    while left <= right:
        middle = (left + right) // 2
        if li[middle] >= target:
            if li[middle] == target: #찾음
                lower_bound = middle
            right = middle - 1 #찾았어도 왼쪽 범위 계속 확인
        else:
            left = middle + 1
    return lower_bound

def bin_search_upper_bound(li, target):
    upper_bound = -1
    left = 0
    right = len(li) - 1
    while left <= right:
        middle = (left + right) // 2
        if li[middle] <= target:
            if li[middle] == target: #찾음
                upper_bound = middle + 1
            left = middle + 1 #찾았어도 오른쪽 범위 계속 확인
        else:
            right = middle - 1
    return upper_bound

def main():
    _ = input()
    cards = sorted(map(int, input().split())) #정렬
    _ = input()
    targets = list(map(int, input().split()))

    for target in targets:
        #시작과 끝 인덱스 이진 탐색 O(logn)
        target_lb = bin_search_lower_bound(cards, target)
        if target_lb == -1: #시작 인덱스 없음
            write("0 ")
            continue
        target_ub = bin_search_upper_bound(cards, target)
        write(f"{target_ub - target_lb} ")

main()
'''