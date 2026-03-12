import heapq
import sys
input = sys.stdin.readline

def run_dual_priority_queue(out):
    k = int(input())

    #(num, index)
    min_heap = []
    max_heap = []
    visited = [False] * k

    for i in range(k):
        line = input().split()
        operation = line[0]
        num = int(line[1])

        if operation == "I": #삽입
            heapq.heappush(min_heap, (num, i))
            heapq.heappush(max_heap, (-num, i))
        else:
            if num == -1: #최솟값 삭제
                while min_heap:
                    if visited[min_heap[0][1]]: #방문했던 노드 삭제
                        heapq.heappop(min_heap)
                        continue
                    visited[min_heap[0][1]] = True
                    heapq.heappop(min_heap)
                    break
            else: #최댓값 삭제
                while max_heap: 
                    if visited[max_heap[0][1]]: #방문했던 노드 삭제
                        heapq.heappop(max_heap)
                        continue
                    visited[max_heap[0][1]] = True
                    heapq.heappop(max_heap)
                    break
    while min_heap and visited[min_heap[0][1]]: heapq.heappop(min_heap)
    while max_heap and visited[max_heap[0][1]]: heapq.heappop(max_heap)

    if min_heap:
        out.append(f"{-max_heap[0][0]} {min_heap[0][0]}") #최댓값 최솟값 출력
    else:
        out.append("EMPTY")


def main():
    t = int(input())
    out = []
    for _ in range(t):
        run_dual_priority_queue(out)
    print("\n".join(out))

main()