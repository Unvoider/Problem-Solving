import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    private static class Point{
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
        int[][] graph;
        int[][] depths;
        Deque<Point> bfs = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m]; // 격자 그래프
        depths = new int[n][m];
        for(int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < m; c++) {
                int num = Integer.parseInt(st.nextToken());
                graph[r][c] = num;
                if(num == 1)
                    depths[r][c] = -1;
                else if(num == 2) // 목표 지점
                    bfs.addLast(new Point(r, c));
            }
        }

        while(!bfs.isEmpty()) { // 너비 우선 탐색
            Point start = bfs.removeFirst();
            for(Point moveDir: MOVE_DIR) {
                int endR = start.r + moveDir.r;
                int endC = start.c + moveDir.c;
                if(endR < 0 || endR >= n || endC < 0 || endC >= m)
                    continue;
                if(graph[endR][endC] == 1) { // 갈 수 있음
                    graph[endR][endC] = 0; // 방문 표시
                    depths[endR][endC] = depths[start.r][start.c] + 1; // 깊이 계산
                    bfs.addLast(new Point(endR, endC));
                }
            }
        }

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++)
                sb.append(depths[r][c]).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}