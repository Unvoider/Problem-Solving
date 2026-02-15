import sys
input = sys.stdin.readline

n, m = map(int, input().split())

unheard = set() #듣도 못한 사람
for _ in range(n):
    unheard.add(input().rstrip())

unseen = set() #보도 못한 사람
for _ in range(m):
    unseen.add(input().rstrip())

unheard_unseen = sorted(unheard & unseen) #듣도 보도 못한 사람
print(len(unheard_unseen))
print("\n".join(unheard_unseen))


'''
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

unheard = set() #듣도 못한 사람
for _ in range(n):
    unheard.add(input().rstrip())

unheard_unseen = [] #듣도 보도 못한 사람
for _ in range(m):
    name = input().rstrip()
    if name in unheard:
        unheard_unseen.append(name)

unheard_unseen.sort() #사전순 정렬
print(len(unheard_unseen))
print("\n".join(unheard_unseen))
'''