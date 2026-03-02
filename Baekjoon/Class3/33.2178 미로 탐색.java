import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    private static class Point {
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
        int[][] depths;
        Deque<Point> bfs = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        depths = new int[n][m]; // 벽 0
        for(int x = 0; x < n; x++) {
            String row = br.readLine();
            for(int y = 0; y < m; y++)
                if(row.charAt(y) == '1')
                    depths[x][y] = -1; // 길 -1
        }

        bfs.addLast(new Point(0, 0)); // 출발 위치 (0, 0)
        depths[0][0] = 1; // 출발 깊이 1
        while(true) {
            Point start = bfs.removeFirst();
            if(start.x == n - 1 && start.y == m - 1) // 도착 위치 (n - 1, m - 1)
                break;
            for(Point moveDir: MOVE_DIR) {
                int endX = start.x + moveDir.x;
                int endY = start.y + moveDir.y;
                if(endX < 0 || endX >= n || endY < 0 || endY >= m) // 경계 확인
                    continue;
                if(depths[endX][endY] == -1) { // 이동
                    bfs.addLast(new Point(endX, endY));
                    depths[endX][endY] = depths[start.x][start.y] + 1;
                }
            }
        }

        System.out.print(depths[n - 1][m - 1]); // 도착 깊이
        br.close();
    }
}