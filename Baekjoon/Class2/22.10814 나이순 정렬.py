import sys
input = sys.stdin.readline

n = int(input())
people = []
for _ in range(n):
    age, name = input().rstrip().split(" ")
    people.append([int(age), name])

people.sort(key = lambda person: person[0])
print("\n".join([f"{person[0]} {person[1]}" for person in people]))