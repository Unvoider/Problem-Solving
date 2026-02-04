import sys
input = sys.stdin.readline

ORD_START = ord("a") - 1
R = 31
M = 1234567891

def get_hash(string):
    hash = 0
    power = 1
    for ch in string:
        #오버플로우를 방지하기 위해 hash와 power에 나머지 연산
        hash = (hash + (ord(ch) - ORD_START) * power) % M
        power = power * R % M
    return hash

def main():
    _ = input()
    string = input().rstrip()
    print(get_hash(string))

main()