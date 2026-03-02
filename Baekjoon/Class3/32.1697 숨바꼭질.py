from collections import deque
import sys
input = sys.stdin.readline

MAX_POS = 100000

class HideAndSeek:
    def __init__(self, seeker, hider):
        depths = [-1] * (MAX_POS + 1)
        bfs = deque([seeker]) #너비 우선 탐색
        depths[seeker] = 0
        while True:
            start = bfs.popleft()
            if start == hider: #찾음
                break
            ends = (start - 1, start + 1, start * 2) #못 찾음
            for end in ends:
                if 0 <= end <= MAX_POS and depths[end] == -1:
                    bfs.append(end)
                    depths[end] = depths[start] + 1
        self._seek_time = depths[hider]
    
    @property
    def seek_time(self):
        return self._seek_time

def main():
    n, k = map(int, input().split())
    print(HideAndSeek(n, k).seek_time)

main()