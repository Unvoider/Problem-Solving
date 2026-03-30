import heapq
import sys
input = sys.stdin.readline

DIST_LIMIT = 500000000

def dijkstra(begin, finish, graph):
    size = len(graph)
    dists = [DIST_LIMIT] * size; #begin에서부터 다른 노드로의 거리
    dists[begin] = 0 #자기 자신에 대한 거리
    pq = [(0, begin)] #최소 힙

    while pq:
        shortest_end = heapq.heappop(pq)[1] #begin에서부터 가장 거리가 짧은 노드 가져오기
        if shortest_end == finish: break
        for adjacent_weight, via_end in graph[shortest_end]: #해당 노드의 인접 노드 확인
            via_dist = dists[shortest_end] + adjacent_weight
            if via_dist < dists[via_end]: #경유했을 때 기존 경로보다 짧으면 업데이트 및 추가
                dists[via_end] = via_dist
                heapq.heappush(pq, (via_dist, via_end))
    return dists[finish]

def main():
    n, e = map(int, input().split())

    graph = [[] for _ in range(n + 1)] # 무방향성 그래프
    for _ in range(e):
        a, b, c = map(int, input().split())
        graph[a].append((c, b)) #(weight, end)
        graph[b].append((c, a))

    v1, v2 = map(int, input().split())
    from_v1_to_v2 = dijkstra(1, v1, graph) + dijkstra(v1, v2, graph) + dijkstra(v2, n, graph)
    from_v2_to_v1 = dijkstra(1, v2, graph) + dijkstra(v2, v1, graph) + dijkstra(v1, n, graph)
    if from_v1_to_v2 >= DIST_LIMIT and from_v2_to_v1 >= DIST_LIMIT: #경로 없음
        print(-1)
    else: #v1, v2를 경유
        print(min(from_v1_to_v2, from_v2_to_v1))
    
main()