import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

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

    private static class CountColorArea {
        private interface ColorComparator {
            boolean isEqual(char color1, char color2);
        }

        private int areaCount = 0;
        public CountColorArea(char[][] colors, ColorComparator cmp) {
            int n = colors.length;
            boolean[][] visited = new boolean[n][n];
            for(int r = 0; r < n; r++)
                for(int c = 0; c < n; c++)
                    if (!visited[r][c]) { // 처음 발견한 색
                        char currentColor = colors[r][c];
                        areaCount++; // 개수 세기
                        Deque<Point> bfs = new ArrayDeque<>(); // 너비 우선 탐색
                        bfs.addLast(new Point(r, c));
                        visited[r][c] = true;
                        while(!bfs.isEmpty()) {
                            Point start = bfs.removeFirst();
                            for (Point moveDir: MOVE_DIR) {
                                int endR = start.r + moveDir.r;
                                int endC = start.c + moveDir.c;
                                if(endR < 0 || endR >= n || endC < 0 || endC >= n)
                                    continue;
                                // 주변 같은 색 발견
                                if (!visited[endR][endC] && cmp.isEqual(currentColor, colors[endR][endC])) {
                                    bfs.addLast(new Point(endR, endC));
                                    visited[endR][endC] = true;
                                }
                            }
                        }
                    }
        }
        public int getCount() {
            return areaCount;
        }
    }

    public static void main(String[] args) throws IOException {
        int n;
        char[][] colors;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        colors = new char[n][]; // 격자 그래프
        for(int i = 0; i < n; i++)
            colors[i] = br.readLine().toCharArray();

        sb.append(new CountColorArea(colors, (color1, color2) -> { // 일반 비교 함수
            return color1 == color2;
        }).getCount()).append(' ');
        sb.append(new CountColorArea(colors, (color1, color2) -> { // 색맹 비교 함수
            return color1 == color2
                    || color1 == 'R' && color2 == 'G'
                    || color1 == 'G' && color2 == 'R';
        }).getCount());
        System.out.print(sb);
        br.close();
    }
}