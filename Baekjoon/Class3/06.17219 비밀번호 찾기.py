import sys
input = sys.stdin.readline

n, m = map(int, input().split())
passwords = dict(input().split() for _ in range(n)) #{site: password}
out = []
for _ in range(m): #비밀번호 출력
    site = input().rstrip()
    out.append(passwords.get(site))
print("\n".join(out))