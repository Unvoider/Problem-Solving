import heapq
import sys
input = sys.stdin.readline

DISTANCE_LIMIT = 100000000

def dijkstra(begin, finish, graph):
    size = len(graph)
    costs = [DISTANCE_LIMIT] * size #begin에서부터 다른 노드로의 비용
    pq = [] #최소 힙

    costs[begin] = 0 #자기 자신에 대한 비용
    heapq.heappush(pq, (0, begin)) #(cost, end)

    while pq:
        shortest_end = heapq.heappop(pq)[1] #begin에서부터 가장 비용이 적은 노드 가져오기
        if shortest_end == finish:
            break
        for adjacent_cost, adjacent_end in graph[shortest_end]: #해당 노드의 인접 노드 확인
            via_cost = costs[shortest_end] + adjacent_cost
            if via_cost < costs[adjacent_end]: #경유했을 때 기존 경로보다 싸면 업데이트 및 추가
                costs[adjacent_end] = via_cost
                heapq.heappush(pq, (via_cost, adjacent_end))
    return costs[finish]

def main():
    n = int(input())
    m = int(input())

    graph = [[] for _ in range(n + 1)] #(cost, end) 방향성 그래프
    for i in range(m):
        start, end, cost = map(int, input().split())
        graph[start].append((cost, end))
    
    begin, finish = map(int, input().split())
    print(dijkstra(begin, finish, graph))

main()