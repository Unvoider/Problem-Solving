#유클리트 호제법
import sys
input = sys.stdin.readline

def gcd(a, b): #greatest common divisor
    while b != 0:
        a, b = b, a % b
    return a

def lcm(a, b): #least common multiple
    return a * b // gcd(a, b)

def main():
    a, b = map(int, input().split())
    print(f"{gcd(a, b)}\n{lcm(a, b)}")

main()