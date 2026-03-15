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
    prev_num = -1
    for i in range(0, n):
        if not visited[i]:
            cur_num = nums[i]
            if prev_num == cur_num: #해당 깊이 직전 숫자와 같으면 건너뛰기
                continue
            else:
                prev_num = cur_num
            track.append(cur_num) #추가
            visited[i] = True
            back_track()
            track.pop() #삭제
            visited[i] = False

back_track()