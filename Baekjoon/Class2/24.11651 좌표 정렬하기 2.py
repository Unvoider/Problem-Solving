import sys
input = sys.stdin.readline

n = int(input())
coords = []
for _ in range(n):
    x, y = map(int, input().split())
    coords.append([x, y])

coords.sort(key = lambda coord: (coord[1], coord[0]))
print("\n".join([f"{coord[0]} {coord[1]}" for coord in coords]))