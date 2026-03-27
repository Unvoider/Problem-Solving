import sys
input = sys.stdin.readline

MAX_DIST = 1000000000

n, m = map(int, input().split()) #행렬 크기, 폐업시키지 않을 치킨 집 수

houses = []
chickens = []
for r in range(n): #집과 치킨집의 위치 저장
    row = input().rstrip().split()
    for c, ch in enumerate(row):
        if ch == "1":
            houses.append((r, c))
        elif ch == "2":
            chickens.append((r, c))

#타뷸레이션
chicken_dists = [ #각 집과 치킨집의 최소 거리 구하기
    [abs(chickens[j][0] - houses[i][0]) + abs(chickens[j][1] - houses[i][1]) for j in range(len(chickens))]
    for i in range(len(houses))
]
        
is_open = [False] * len(chickens)
chicken_dist = MAX_DIST

def choose_chickens(cur, count):
    global chicken_dist

    if count == m: #m개 선택됨
        total_min_dist = 0
        for i in range(len(houses)): #각 집과 열린 치킨집의 최소 거리 누적
            min_dist = MAX_DIST
            for j in range(len(chickens)):
                if is_open[j]:
                    min_dist = min(min_dist, chicken_dists[i][j])
            total_min_dist += min_dist
        chicken_dist = min(chicken_dist, total_min_dist) #최소 거리 업데이트
        return
    
    for i in range(cur, len(chickens)): #모든 조합 확인
        is_open[i] = True
        choose_chickens(i + 1, count + 1)
        is_open[i] = False #백트래킹

chicken_dist = MAX_DIST
choose_chickens(0, 0)
print(chicken_dist)