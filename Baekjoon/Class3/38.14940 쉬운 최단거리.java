import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    private static class Point{
        int x, y;
        public Point(int x, int y) { this.x = x; this.y = y; }
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
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
                if(num == 1)
                    depths[i][j] = -1;
                else if(num == 2) // 목표 지점
                    bfs.addLast(new Point(i, j));
            }
        }

        while(!bfs.isEmpty()) { // 너비 우선 탐색
            Point start = bfs.removeFirst();
            for(Point moveDir: MOVE_DIR) {
                int endX = start.x + moveDir.x;
                int endY = start.y + moveDir.y;
                if(endX < 0 || endX >= n || endY < 0 || endY >= m)
                    continue;
                if(graph[endX][endY] == 1) { // 갈 수 있음
                    graph[endX][endY] = 0; // 방문 표시
                    depths[endX][endY] = depths[start.x][start.y] + 1; // 깊이 계산
                    bfs.addLast(new Point(endX, endY));
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++)
                sb.append(depths[i][j]).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}