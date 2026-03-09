import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    private static class Point {
        int p, r, c; // page, row, column
        public Point(int p, int r, int c) {
            this.p = p;
            this.r = r;
            this.c = c;
        }
    }
    private static final Point[] MOVE_DIR = {
            new Point(-1, 0, 0),
            new Point(1, 0, 0),
            new Point(0, -1, 0),
            new Point(0, 1, 0),
            new Point(0, 0, -1),
            new Point(0, 0, 1)
    };
    private static final int NO_TOMATO = -1;
    private static final int UNRIPE_TOMATO = -2;

    public static void main(String[] args) throws IOException {
        int m, n, h;
        int unripeTomatoCount = 0, ripeTime = 0;
        int[][][] depths;
        Deque<Point> bfs = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        depths = new int[h][n][m]; // 격자 그래프
        for(int p = 0; p < h; p++)
            for(int r = 0; r < n; r++)
                Arrays.fill(depths[p][r], NO_TOMATO);

        for(int p = 0; p < h; p++)
            for(int r = 0; r < n; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < m; c++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    if(tomato == 1) { // 익음
                        bfs.addLast(new Point(p, r, c));
                        depths[p][r][c] = 0;
                    }
                    else if(tomato == 0) { // 익지 않음
                        depths[p][r][c] = UNRIPE_TOMATO;
                        unripeTomatoCount++;
                    }
                }
            }

        while(!bfs.isEmpty()) { // 너비 우선 탐색
            Point start = bfs.removeFirst();
            for(Point moveDir: MOVE_DIR) {
                int endP = start.p + moveDir.p;
                int endR = start.r + moveDir.r;
                int endC = start.c + moveDir.c;
                if(endP < 0 || endP >= h || endR < 0 || endR >= n || endC < 0 || endC >= m)
                    continue;
                if(depths[endP][endR][endC] == UNRIPE_TOMATO) { // 인접 토마토가 익지 않음
                    bfs.addLast(new Point(endP, endR, endC)); // 익히기
                    ripeTime = depths[endP][endR][endC] = depths[start.p][start.r][start.c] + 1;
                    unripeTomatoCount--;
                }
            }
        }

        if(unripeTomatoCount == 0)
            System.out.print(ripeTime);
        else
            System.out.print(-1);
        br.close();
    }
}