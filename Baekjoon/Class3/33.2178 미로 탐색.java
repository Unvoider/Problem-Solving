import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
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

    public static void main(String[] args) throws IOException {
        int n, m;
        int[][] depths;
        Deque<Point> bfs = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        depths = new int[n][m]; // 벽 0
        for(int r = 0; r < n; r++) {
            String row = br.readLine();
            for(int c = 0; c < m; c++)
                if(row.charAt(c) == '1')
                    depths[r][c] = -1; // 길 -1
        }

        bfs.addLast(new Point(0, 0)); // 출발 위치 (0, 0)
        depths[0][0] = 1; // 출발 깊이 1
        while(true) {
            Point start = bfs.removeFirst();
            if(start.r == n - 1 && start.c == m - 1) // 도착 위치 (n - 1, m - 1)
                break;
            for(Point moveDir: MOVE_DIR) {
                int endR = start.r + moveDir.r;
                int endC = start.c + moveDir.c;
                if(endR < 0 || endR >= n || endC < 0 || endC >= m) // 경계 확인
                    continue;
                if(depths[endR][endC] == -1) { // 이동
                    bfs.addLast(new Point(endR, endC));
                    depths[endR][endC] = depths[start.r][start.c] + 1;
                }
            }
        }

        System.out.print(depths[n - 1][m - 1]); // 도착 깊이
        br.close();
    }
}