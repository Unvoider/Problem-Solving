import sys
input = sys.stdin.readline
write = sys.stdout.write

def vps(ps): #valid parenthesis string
    count = 0
    for ch in ps:
        if ch == "(": #왼쪽 괄호 count += 1
            count += 1
        else: #오른쪽 괄호 count -= 1
            if count == 0: return False #count 빔
            else: count -= 1
    return count == 0 #남은 괄호 없으면 성공

def main():
    t = int(input())
    for _ in range(t):
        ps = input().rstrip()
        if vps(ps): write("YES\n")
        else: write("NO\n")

main()