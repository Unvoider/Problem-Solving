import sys
input = sys.stdin.readline
write = sys.stdout.write

n, m = map(int, input().split())
visited = [False] * (n + 1)
track = []

def back_track(start):
    if len(track) == m: #출력
        write(f"{" ".join(track)}\n")
        return
    for i in range(start, n + 1):
        if not visited[i]:
            track.append(str(i)) #추가
            visited[i] = True
            back_track(i + 1)
            track.pop() #삭제
            visited[i] = False

back_track(1)