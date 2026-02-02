import sys
input = sys.stdin.readline

FIRST_ORD = ord("a")

s = input().strip()
first_appearance = [-1] * 26
for i, ch in enumerate(s):
    index = ord(ch) - FIRST_ORD
    if first_appearance[index] == -1:
        first_appearance[index] = i
print(" ".join(map(str, first_appearance)))
#print(*(first_appearance))