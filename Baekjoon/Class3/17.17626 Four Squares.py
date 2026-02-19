import sys
input = sys.stdin.readline

def is_square(n): #제곱수인지 확인
    root = int(n ** 0.5)
    return root * root == n

def main():
    n = int(input())
    power_max = int(n ** 0.5)
    powers = [i * i for i in range(power_max + 1)] #타뷸레이션

    if powers[power_max] == n: #1개
        print(1)
        return
    
    for i in range(1, power_max + 1, 1): #2개
        remainder = n - powers[i]
        if remainder < 1:
            break
        if is_square(remainder):
            print(2)
            return

    for i in range(1, power_max + 1, 1): #3개
        for j in range(1, i + 1, 1):
            remainder = n - powers[i] - powers[j]
            if remainder < 1:
                break
            if is_square(remainder):
                print(3)
                return
    
    print(4) #4개

main()