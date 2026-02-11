import sys
input = sys.stdin.readline
write = sys.stdout.write

class Stack: #연결 리스트 스택
    class Node: #연결 리스트 노드
        def __init__(self, data, next):
            self.data = data
            self.next = next
    def __init__(self):
        self._top = None #첫 노드
        self._size = 0
    def push(self, data):
        self._size += 1
        node_to_push = self.Node(data, self._top)
        self._top = node_to_push
    def pop(self):
        if self.empty(): raise IndexError("stack is empty")
        self._size -= 1
        data = self._top.data
        self._top = self._top.next
        return data
    def size(self):
        return self._size
    def empty(self):
        return self._size == 0
    def top(self):
        if self.empty(): raise IndexError("stack is empty")
        return self._top.data

def main():
    n = int(input())
    nums = Stack()

    for _ in range(n):
        line = input().split()
        command = line[0]
        try:
            match(command):
                case "push":
                    nums.push(int(line[1]))
                case "pop":
                    write(f"{nums.pop()}\n")
                case "size":
                    write(f"{nums.size()}\n")
                case "empty":
                    write(f"{int(nums.empty())}\n")
                case "top":
                    write(f"{nums.top()}\n")
        except IndexError: #스택 빔
            write("-1\n")

main()

''' 라이브러리 사용
from collections import deque
import sys
input = sys.stdin.readline
write = sys.stdout.write

n = int(input())
nums = deque()

for _ in range(n):
    line = input().split()
    command = line[0]
    match(command):
        case "push":
            nums.append(int(line[1]))
        case "pop":
            if len(nums) == 0:
                write("-1\n")
                continue
            write(f"{nums.pop()}\n")
        case "size":
            write(f"{len(nums)}\n")
        case "empty":
            write(f"{int(not nums)}\n")
        case "top":
            if not nums:
                write("-1\n")
                continue
            write(f"{nums[-1]}\n")
'''