// 깊이 우선 탐색
#include <iostream>
#include <vector>
using namespace std;

struct Point {
    int r, c;
};
constexpr Point MOVE_DIR[4] = {
    {-1, 0},
    {1, 0},
    {0, -1},
    {0, 1}
};

int max_score = 0;
int max_total = 0;
vector<vector<int>> scores;
vector<vector<char>> visited;

void search_max_total(int start_r, int start_c, int total, int depth) {
    if (total + max_score * (4 - depth) <= max_total) // 아무리 더해도 새 최댓값이 될 수 없음
        return;

    if (depth == 4) { // 깊이가 4일 때까지 모든 테트로미노 찾기
        if (total > max_total) max_total = total;
        return;
    }
    for (const Point& move_dir : MOVE_DIR) {
        int end_r = start_r + move_dir.r;
        int end_c = start_c + move_dir.c;
        if (end_r < 0 || end_r >= scores.size() || end_c < 0 || end_c >= scores[0].size())
            continue;
        if (!visited[end_r][end_c]) {
            if (depth == 2) { // 깊이가 2면 ㅜ 모양 테트로미노 찾기
                visited[end_r][end_c] = true;
                search_max_total(start_r, start_c, total + scores[end_r][end_c], depth + 1);
                visited[end_r][end_c] = false;
            }
            visited[end_r][end_c] = true;
            search_max_total(end_r, end_c, total + scores[end_r][end_c], depth + 1);
            visited[end_r][end_c] = false;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    scores = vector<vector<int>>(n, vector<int>(m));
    for (int r = 0; r < n; r++)
        for (int c = 0; c < m; c++) {
            int score;
            cin >> score;
            scores[r][c] = score;
            if (score > max_score) max_score = score;
        }
    visited = vector<vector<char>>(n, vector<char>(m));

    for (int r = 0; r < n; r++)
        for (int c = 0; c < m; c++) {
            visited[r][c] = true;
            search_max_total(r, c, 0, 0);
            visited[r][c] = false;
        }
    cout << max_total;
    return 0;
}

/* 브루트포스
#include <iostream>
#include <vector>
#include <array>
using namespace std;
using Tetromino = array<array<int, 2>, 5>; // {세로, 가로}, {r1, c1}...

constexpr int TETROMINO_TYPES[5][6][2] = { // {회전 횟수, 대칭}, {세로, 가로}, {r1, c1}...
    { {1, 0}, {1, 4}, {0, 0}, {0, 1}, {0, 2}, {0, 3} },
    { {0, 0}, {2, 2}, {0, 0}, {0, 1}, {1, 0}, {1, 1} },
    { {3, 1}, {3, 2}, {0, 0}, {1, 0}, {2, 0}, {2, 1} },
    { {1, 1}, {3, 2}, {0, 0}, {1, 0}, {1, 1}, {2, 1} },
    { {3, 0}, {2, 3}, {0, 0}, {0, 1}, {0, 2}, {1, 1} }
};

// 모든 테트로미노 미리 계산
vector<Tetromino> tetrominoes;
void init_tetrominoes() {
    for (int i = 0; i < 5; i++) {
        Tetromino tetromino;
        for (int j = 0; j < 5; j++) { // 원형 복사
            tetromino[j][0] = TETROMINO_TYPES[i][j + 1][0];
            tetromino[j][1] = TETROMINO_TYPES[i][j + 1][1];
        }

        int rotation = TETROMINO_TYPES[i][0][0];
        int mirror = TETROMINO_TYPES[i][0][1];

        for (int r = 0; r <= rotation; r++) {
            tetrominoes.push_back(tetromino); // 추가
            if (mirror) {
                Tetromino mirrored;
                mirrored[0][0] = tetromino[0][0];
                mirrored[0][1] = tetromino[0][1];
                for (int j = 1; j < 5; j++) {
                    mirrored[j][0] = tetromino[j][0];
                    mirrored[j][1] = tetromino[0][1] - tetromino[j][1] - 1;
                }
                tetrominoes.push_back(mirrored); // 대칭 추가
            }
            if (r == rotation) break; // 완료
            Tetromino rotated;
            rotated[0][0] = tetromino[0][1];
            rotated[0][1] = tetromino[0][0];
            for (int j = 1; j < 5; j++) {
                rotated[j][0] = tetromino[j][1];
                rotated[j][1] = tetromino[0][0] - tetromino[j][0] - 1;
            }
            tetromino = rotated; // 90도 회전
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    init_tetrominoes();

    int n, m;
    cin >> n >> m;

    vector<vector<int>> scores(n, vector<int>(m));
    for (int r = 0; r < n; r++)
        for (int c = 0; c < m; c++)
            cin >> scores[r][c];

    int max_total = 0;
    for (const Tetromino& tetromino : tetrominoes) // 모든 테트로미노에 대해
        for (int r = 0; r <= n - tetromino[0][0]; r++)
            for (int c = 0; c <= m - tetromino[0][1]; c++) { // 최댓값 찾기
                int total = 0;
                for (int i = 1; i < 5; i++)
                    total += scores[r + tetromino[i][0]][c + tetromino[i][1]];
                if (total > max_total) max_total = total;
            }
    cout << max_total;
    return 0;
}
*/