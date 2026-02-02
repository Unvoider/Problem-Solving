import math
import sys
input = sys.stdin.readline

n = int(input())
t_counts = list(map(int, input().split()))
t_bundle, p_bundle = map(int, input().split())

#티셔츠 묶음
t = 0
for t_count in t_counts:
    t += math.ceil(t_count / t_bundle)
    #t += (t_count + t_bundle - 1) // t_bundle

#펜 묶음과 낱개
p = n // p_bundle
p_rest = n % p_bundle

print(f"{t}\n{p} {p_rest}")