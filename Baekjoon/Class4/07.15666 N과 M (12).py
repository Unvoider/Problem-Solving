import sys
input = sys.stdin.readline
write = sys.stdout.write

_, m = map(int, input().split())
track = []
nums = list(map(str, sorted(set(map(int, input().split()))))) #중복 제거, 정렬

def back_track(start):
    if len(track) == m: #출력
        write(f"{" ".join(track)}\n")
        return
    for i in range(start, len(nums)):
            track.append(nums[i]) #추가
            back_track(i)
            track.pop() #삭제

back_track(0)