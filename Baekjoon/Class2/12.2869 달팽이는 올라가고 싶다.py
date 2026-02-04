import sys
input = sys.stdin.readline

def div_ceil(x, y):
    return (x + y - 1) // y

def main():
    a, b, v = map(int, input().split())
    #첫 상승을 제외한 거리: v - a
    #매일 상승 거리: a - b
    print(div_ceil(v - a, a - b) + 1)
    #위의 전개식:
    #print((v - b - 1) // (a - b) + 1)

main()