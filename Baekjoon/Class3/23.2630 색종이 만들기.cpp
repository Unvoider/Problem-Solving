#include <iostream>
#include <vector>
using namespace std;
constexpr char WHITE = '0';
constexpr char BLUE = '1';

struct PaperCount {
    int white;
    int blue;
};

vector<vector<char>> paper;

bool is_uniform(int r, int c, int size) {
    char first = paper[r][c];
    for (int i = r; i < r + size; i++)
        for (int j = c; j < c + size; j++)
            if (first != paper[i][j])
                return false;
    return true;
}

PaperCount cut_papers(int r, int c, int size) {
    if (is_uniform(r, c, size)) // 모두 같은 색일 때 종료
        return { paper[r][c] == WHITE, paper[r][c] == BLUE };

    int half = size / 2; // 사등분
    int white = 0, blue = 0;
    for (int i = 0; i < 2; i++)
        for (int j = 0; j < 2; j++) {
            PaperCount paper_count = cut_papers(r + i * half, c + j * half, half);
            white += paper_count.white;
            blue += paper_count.blue;
        }
    return { white, blue };
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    paper.assign(n, vector<char>(n));
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cin >> paper[i][j];

    PaperCount paper_count = cut_papers(0, 0, n);
    cout << paper_count.white << '\n';
    cout << paper_count.blue << '\n';
    return 0;
}