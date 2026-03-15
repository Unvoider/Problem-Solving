import sys
input = sys.stdin.readline
write = sys.stdout.write

n, m = map(int, input().split())
visited = [False] * (n)
track = []
nums = list(map(str, sorted(map(int, input().split())))) #정렬

def back_track():
    if len(track) == m: #출력
        write(f"{" ".join(track)}\n")
        return
    for i in range(0, n):
        if not visited[i]:
            track.append(nums[i]) #추가
            visited[i] = True
            back_track()
            track.pop() #삭제
            visited[i] = False

back_track()