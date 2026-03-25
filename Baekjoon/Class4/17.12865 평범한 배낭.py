import sys
input = sys.stdin.readline

n, k = map(int, input().split())

max_acc_vals = [0] * (k + 1) #가방 용량에 따른 모든 물건 가치 누적
for _ in range(n):
    w, v = map(int, input().split())
    for i in range(k, w - 1, -1): #_번째 물건이 중복 처리되는 것을 방지하기 위해 역순으로 처리
        #해당 물건을 넣지 않았을 때의 최댓값과, 해당 물건을 넣었을 때 나머지 용량에 넣을 수 있는 최댓값 비교
        max_acc_vals[i] = max(max_acc_vals[i], v + max_acc_vals[i - w])

print(max_acc_vals[k])