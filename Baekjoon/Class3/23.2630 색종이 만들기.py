import sys
input = sys.stdin.readline

def is_uniform(x, y, size, paper):
    first = paper[x][y]
    for i in range(x, x + size):
        for j in range(y, y + size):
            if first != paper[i][j]:
                return False
    return True

def cut_papers(x, y, size, paper): #return (white, blue)
    if is_uniform(x, y, size, paper): #모두 같은 색일 때 종료
        return (1, 0) if paper[x][y] == 0 else (0, 1)

    half = size // 2 #사등분
    white = 0
    blue = 0
    for i in range(2):
        for j in range(2):
            (w, b) = cut_papers(x + i * half, y + j * half, half, paper)
            white += w
            blue += b
    return (white, blue)

def main():
    n = int(input())
    paper = [list(map(int, input().split())) for _ in range(n)]
    
    (w, b) = cut_papers(0, 0, n, paper)
    print(f"{w}\n{b}")

main()