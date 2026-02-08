# 반복 동적 프로그래밍
import sys
input = sys.stdin.readline

INF = 5001

n = int(input())
bag_counts = [INF] * (n + 1) #메모이제이션
bag_counts[3] = 1
if n >= 5: bag_counts[5] = 1

for i in range(6, n + 1):
    bag_counts[i] = min(bag_counts[i - 3], bag_counts[i - 5]) + 1; #더 적은 봉지 수에 하나 추가

if bag_counts[n] >= INF: print("-1")
else: print(bag_counts[n])

''' 그리디
import sys
input = sys.stdin.readline

n = int(input())
bag_count = -1

for five_kg in range(n // 5, -1, -1): #5kg 봉지 최대부터 0개까지
    remain = n - (5 * five_kg)
    if remain % 3 == 0: #나머지가 3으로 나눠 떨어지면 종료
        bag_count = five_kg + (remain // 3)
        break
print(bag_count)
'''

''' 재귀 동적 프로그래밍
import sys
sys.setrecursionlimit(2000)
input = sys.stdin.readline

INF = 5001

def count_bags(kg, bag_counts):
    if kg <= 5: return bag_counts[kg]
    if bag_counts[kg] == INF: #아직 계산 안 됨
        #더 적은 봉지 수에 하나 추가
        bag_counts[kg] = min(count_bags(kg - 3, bag_counts), count_bags(kg - 5, bag_counts)) + 1
    return bag_counts[kg]

def main():
    n = int(input())
    bag_counts = [INF] * (n + 1) #메모이제이션
    bag_counts[3] = 1
    if n >= 5: bag_counts[5] = 1

    bag_count = count_bags(n, bag_counts)
    if bag_count >= INF: print("-1")
    else: print(bag_count)

main()
'''