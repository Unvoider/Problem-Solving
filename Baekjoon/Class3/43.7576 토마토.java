import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    private static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    private static final Point[] MOVE_DIR = {
            new Point(-1, 0),
            new Point(1, 0),
            new Point(0, -1),
            new Point(0, 1)
    };
    private static final int NO_TOMATO = -1;
    private static final int UNRIPE_TOMATO = -2;

    public static void main(String[] args) throws IOException {
        int m, n;
        int unripeTomatoCount = 0, ripeTime = 0;
        int[][] depths;
        Deque<Point> bfs = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        depths = new int[n][m]; // 격자 그래프
        for(int r = 0; r < n; r++)
            Arrays.fill(depths[r], NO_TOMATO);

        for(int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < m; c++) {
                int tomato = Integer.parseInt(st.nextToken());
                if(tomato == 1) { // 익음
                    bfs.addLast(new Point(r, c));
                    depths[r][c] = 0;
                }
                else if(tomato == 0) { // 익지 않음
                    depths[r][c] = UNRIPE_TOMATO;
                    unripeTomatoCount++;
                }
            }
        }

        while(!bfs.isEmpty()) { // 너비 우선 탐색
            Point start = bfs.removeFirst();
            for(Point moveDir: MOVE_DIR) {
                int endR = start.r + moveDir.r;
                int endC = start.c + moveDir.c;
                if(endR < 0 || endR >= n || endC < 0 || endC >= m)
                    continue;
                if(depths[endR][endC] == UNRIPE_TOMATO) { // 인접 토마토가 익지 않음
                    bfs.addLast(new Point(endR, endC)); // 익히기
                    ripeTime = depths[endR][endC] = depths[start.r][start.c] + 1;
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