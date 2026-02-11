import sys
input = sys.stdin.readline
write = sys.stdout.write

class Queue: #연결 리스트 큐
    class Node: #연결 리스트 노드
        def __init__(self, data, next):
            self.data = data
            self.next = next
    def __init__(self):
        self._front = None #첫 노드
        self._back = None #마지막 노드
        self._size = 0
    def push(self, data):
        self._size += 1
        node_to_push = self.Node(data, None)
        if self._size == 1:
            self._front = self._back = node_to_push
        else:
            self._back.next = node_to_push
            self._back = node_to_push
    def pop(self):
        if self.empty(): raise IndexError("queue is empty")
        self._size -= 1
        data = self._front.data
        self._front = self._front.next
        if self._front == None:
            self._back = None
        return data
    def size(self):
        return self._size
    def empty(self):
        return self._size == 0
    def front(self):
        if self.empty(): raise IndexError("queue is empty")
        return self._front.data
    def back(self):
        if self.empty(): raise IndexError("queue is empty")
        return self._back.data

def main():
    n = int(input())
    nums = Queue()

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
                case "front":
                    write(f"{nums.front()}\n")
                case "back":
                    write(f"{nums.back()}\n")
        except IndexError: #큐 빔
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
            write(f"{nums.popleft()}\n")
        case "size":
            write(f"{len(nums)}\n")
        case "empty":
            write(f"{int(not nums)}\n")
        case "front":
            if not nums:
                write("-1\n")
                continue
            write(f"{nums[0]}\n")
        case "back":
            if not nums:
                write("-1\n")
                continue
            write(f"{nums[-1]}\n")
'''