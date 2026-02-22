import sys
input = sys.stdin.readline
write = sys.stdout.write

class MinHeap:
    def __init__(self):
        self._heap = [None] #root 인덱스 1
    def empty(self):
        return len(self._heap) == 1
    def push(self, data):
        in_pos = len(self._heap) #마지막 인덱스를 삽입 위치로
        parent = in_pos >> 1
        self._heap.append(None)
        #삽입 위치가 root가 아니고 자식 값이 부모 값보다 작은 동안
        while in_pos != 1 and data < self._heap[parent]:
            self._heap[in_pos] = self._heap[parent]; #부모를 자식으로
            in_pos >>= 1; #자식을 부모로
            parent = in_pos >> 1
        self._heap[in_pos] = data
    def pop(self):
        if self.empty(): raise IndexError("heap is empty")
        data = self._heap[1]
        last = self._heap.pop() #마지막 값을 root 자리에 올림
        if self.empty(): return data
        in_pos = 1
        child = 2
        heap_len = len(self._heap)
        while child < heap_len: #자식이 존재하는 동안
            if child + 1 < heap_len and self._heap[child] > self._heap[child + 1]:
                child += 1 #왼쪽/오른쪽 자식 중 더 작은 값 고르기
            if last <= self._heap[child]: break #부모 값이 자식 값보다 큰 동안
            self._heap[in_pos] = self._heap[child] #자식을 부모로
            in_pos = child #부모를 자식으로
            child = in_pos << 1
        self._heap[in_pos] = last
        return data

def main():
    n = int(input())

    min_heap = MinHeap()
    for _ in range(n):
        x = int(input())
        if x == 0:
            if min_heap.empty():
                write("0\n")
            else:
                write(f"{min_heap.pop()}\n")
        else:
            min_heap.push(x)

main()

''' 라이브러리 사용
import heapq
import sys
input = sys.stdin.readline
write = sys.stdout.write

min_heap = []

n = int(input())
for _ in range(n):
    x = int(input())
    if x == 0:
        if min_heap:
            write(f"{min_heap[0]}\n")
            heapq.heappop(min_heap)
        else:
            write("0\n")
    else:
        heapq.heappush(min_heap, x)
'''