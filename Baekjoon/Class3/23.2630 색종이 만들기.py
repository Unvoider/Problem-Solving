import sys
input = sys.stdin.readline

def is_uniform(r, c, size, paper):
    first = paper[r][c]
    for i in range(r, r + size):
        for j in range(c, c + size):
            if first != paper[i][j]:
                return False
    return True

def cut_papers(r, c, size, paper): #return (white, blue)
    if is_uniform(r, c, size, paper): #모두 같은 색일 때 종료
        return (1, 0) if paper[r][c] == 0 else (0, 1)

    half = size // 2 #사등분
    white = 0
    blue = 0
    for i in range(2):
        for j in range(2):
            (w, b) = cut_papers(r + i * half, c + j * half, half, paper)
            white += w
            blue += b
    return (white, blue)

def main():
    n = int(input())
    paper = [list(map(int, input().split())) for _ in range(n)]
    
    (w, b) = cut_papers(0, 0, n, paper)
    print(f"{w}\n{b}")

main()