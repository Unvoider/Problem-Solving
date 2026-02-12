import sys
input = sys.stdin.readline

def positive_round(num: float):
    return int(num + 0.5)

def main():
    n = int(input())
    if n == 0:
        print(0)
        sys.exit(0)
    opinions = [int(input()) for _ in range(n)]
    opinions.sort() #정렬
    exclusion = positive_round(n * 0.15) #절사 범위
    total = sum([opinions[i] for i in range(exclusion, n - exclusion)]) #절사
    print(positive_round(total / (n - 2 * exclusion))) # 평균

main()