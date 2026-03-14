import sys
input = sys.stdin.readline

MOVE_DIR = ((-1, 0), (1, 0), (0, -1), (0, 1))

n, m = map(int, input().split())
scores = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
max_score = max(map(max, scores))
max_total = 0

def search_max_total(start_r, start_c, total, depth):
    global max_total
    if total + max_score * (4 - depth) <= max_total: #아무리 더해도 새 최댓값이 될 수 없음
        return

    if (depth == 4) : #깊이가 4일 때까지 모든 테트로미노 찾기
        max_total = max(max_total, total)
        return
    for move_r, move_c in MOVE_DIR:
        end_r = start_r + move_r
        end_c = start_c + move_c
        if end_r < 0 or end_r >= n or end_c < 0 or end_c >= m:
            continue
        if not visited[end_r][end_c]:
            if depth == 2: #깊이가 2면 ㅜ 모양 테트로미노 찾기
                visited[end_r][end_c] = True
                search_max_total(start_r, start_c, total + scores[end_r][end_c], depth + 1)
                visited[end_r][end_c] = False
            visited[end_r][end_c] = True
            search_max_total(end_r, end_c, total + scores[end_r][end_c], depth + 1)
            visited[end_r][end_c] = False

def main():
    for r in range(n):
        for c in range(m):
            visited[r][c] = True
            search_max_total(r, c, 0, 0)
            visited[r][c] = False
    print(max_total)

main()