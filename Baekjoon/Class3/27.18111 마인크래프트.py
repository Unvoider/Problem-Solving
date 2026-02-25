from collections import Counter
import sys

_, _, b = map(int, sys.stdin.readline().split())
height_counts = Counter(map(int, sys.stdin.read().split()))
min_h = min(height_counts.keys())
max_h = max(height_counts.keys())

min_time = float("inf")
flat_h = 0
for target_h in range(min_h, max_h + 1): #모든 높이 확인
    to_place = 0 #해당 높이에서 설치/삭제해야 하는 블록 수
    to_break = 0
    for cur_h, count in height_counts.items():
        blocks = target_h - cur_h
        if blocks > 0:
            to_place += blocks * count
        elif blocks < 0:
            to_break -= blocks * count
    if b + to_break >= to_place: #인벤토리 블록 수 확인
        time = to_break * 2 + to_place
        if min_time >= time: #최소 시간 갱신
            min_time = time
            flat_h = target_h

print(f"{min_time} {flat_h}")