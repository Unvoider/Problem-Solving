import sys
input = sys.stdin.readline

n = int(input())
for i in range(1, n + 1):
    print(("*" * i).rjust(n))

'''
n = int(input())
for i in range(1, n + 1):
    print(" " * (n - i), end = "")
    print("*" * i)
'''