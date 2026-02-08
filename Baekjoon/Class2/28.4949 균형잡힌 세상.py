from collections import deque
import sys
input = sys.stdin.readline
write = sys.stdout.write

PAIRS = {")": "(", "]": "["}

def balanced_world(string):
    brackets = deque()
    for ch in string:
        if ch in "([": #왼쪽 괄호 push
            brackets.append(ch)
        elif ch in ")]": #오른쪽 괄호 pop
            if len(brackets) == 0: return False #스택 빔
            if brackets.pop() != PAIRS[ch]: #괄호 짝 안 맞음
                return False
    return not brackets #남은 괄호 없으면 성공

def main():
    string = input().rstrip()
    while string != ".":
        if balanced_world(string): write("yes\n")
        else: write("no\n")
        string = input().rstrip()

main()