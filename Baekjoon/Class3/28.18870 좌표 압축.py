#dict 사용
import sys
input = sys.stdin.readline

input()
xn = list(map(int, input().split()))
#중복 제거, 정렬, dict로 순서 저장
compression = {sorted_x: i for i, sorted_x in enumerate(sorted(set(xn)))}
print(*(compression[x] for x in xn))

''' 이진 탐색
from bisect import bisect_left
import sys
input = sys.stdin.readline

input()
xn = list(map(int, input().split()))
sorted_xn = sorted(set(xn)) #중복 제거, 정렬
print(*(bisect_left(sorted_xn, x) for x in xn))
'''