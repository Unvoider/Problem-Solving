import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static class Point {
        int r, c;
        public Point(int r, int c) { this.r = r; this.c = c; }
    }
    private static final Point[] MOVE_DIR = {
            new Point(-1, 0),
            new Point(1, 0),
            new Point(0, -1),
            new Point(0, 1)
    };

    private static int maxScore = 0;
    private static int maxTotal = 0;
    private static int[][] scores;
    private static boolean[][] visited;

    private static void searchMaxTotal(int startR, int startC, int total, int depth) {
        if(total + maxScore * (4 - depth) <= maxTotal) // 아무리 더해도 새 최댓값이 될 수 없음
            return;

        if(depth == 4) { // 깊이가 4일 때까지 모든 테트로미노 찾기
            if(total > maxTotal) maxTotal = total;
            return;
        }
        for(Point moveDir : MOVE_DIR) {
            int endR = startR + moveDir.r;
            int endC = startC + moveDir.c;
            if(endR < 0 || endR >= scores.length || endC < 0 || endC >= scores[0].length)
                continue;
            if(!visited[endR][endC]) {
                if(depth == 2) { // 깊이가 2면 ㅜ 모양 테트로미노 찾기
                    visited[endR][endC] = true;
                    searchMaxTotal(startR, startC, total + scores[endR][endC], depth + 1);
                    visited[endR][endC] = false;
                }
                visited[endR][endC] = true;
                searchMaxTotal(endR, endC, total + scores[endR][endC], depth + 1);
                visited[endR][endC] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        scores = new int[n][m];
        for(int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < m; c++) {
                int score = Integer.parseInt(st.nextToken());
                scores[r][c] = score;
                if(score > maxScore) maxScore = score;
            }
        }
        visited = new boolean[n][m];

        for(int r = 0; r < n; r++)
            for(int c = 0; c < m; c++) {
                visited[r][c] = true;
                searchMaxTotal(r, c, 0, 0);
                visited[r][c] = false;
            }

        System.out.print(maxTotal);
        br.close();
    }
}