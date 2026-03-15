import sys
input = sys.stdin.readline
write = sys.stdout.write

n, m = map(int, input().split())
track = []

def back_track(start):
    if len(track) == m: #출력
        write(f"{" ".join(track)}\n")
        return
    for i in range(start, n + 1):
        track.append(str(i)) #추가
        back_track(i)
        track.pop() #삭제

back_track(1)