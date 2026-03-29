import sys
input = sys.stdin.readline

def collapsing_find(node, parents):
    if parents[node] == node: #루트 반환
        return node
    parents[node] = collapsing_find(parents[node], parents) #자손 노드들을 루트 노드에 달기
    return parents[node]

def union_roots(node1, node2, parents, knows):
    node1 = collapsing_find(node1, parents)
    node2 = collapsing_find(node2, parents)

    if node1 != node2: #두 루트가 다르다면
        if knows[node1]: #지식 전파
            knows[node2] = True
        elif knows[node2]:
            knows[node1] = True
        parents[node1] = node2; #유니언

def main():
    n, m = map(int, input().split()) #사람 수, 파티 수
    knows = [False] * (n + 1)
    parents = [i for i in range(n + 1)] #루트는 자기 자신을 부모로

    knowing_people = list(map(int, input().split()))
    for i in range(1, knowing_people[0] + 1): #아는 사람 설정
        knows[knowing_people[i]] = True
    
    parties = [list(map(int, input().split()))[1:] for _ in range(m)] #파티 참석자 정보
    for party in parties:
        for i in range(len(party) - 1):
            union_roots(party[i], party[i + 1], parents, knows) #파티 참석자 유니언 및 지식 전파
    
    possible_lie_count = 0
    for party in parties:
        can_lie = True
        for visitor in party: #파티마다
            if knows[collapsing_find(visitor, parents)]: #아는 사람이 있으면 거짓말을 못 함
                can_lie = False
                break
        if can_lie: possible_lie_count += 1

    print(possible_lie_count)

main()