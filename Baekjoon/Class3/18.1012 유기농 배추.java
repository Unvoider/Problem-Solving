import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    private static final int[][] MOVE_DIR = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };

    private static void countWorms(BufferedReader br, StringBuilder sb) throws IOException {
        int m, n, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[m][n]; // 격자 그래프
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[r][c] = true;
        }

        Deque<int[]> bfs = new ArrayDeque<>();
        int components = 0;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(graph[r][c]) { // 연결 요소 시작점 찾기
                    bfs.addLast(new int[]{r, c});
                    graph[r][c] = false;
                    components++;
                }
                while(!bfs.isEmpty()) { // 너비 우선 탐색
                    int[] start = bfs.removeFirst();
                    for(int[] moveDir: MOVE_DIR) {
                        int endR = start[0] + moveDir[0];
                        int endC = start[1] + moveDir[1];
                        if(endR < 0 || endR >= m || endC < 0 || endC >= n)
                            continue;
                        if(graph[endR][endC]) {
                            bfs.addLast(new int[]{endR, endC});
                            graph[endR][endC] = false;
                        }
                    }
                }
            }
        }
        sb.append(components).append('\n'); // 연결 요소 수
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++)
            countWorms(br, sb);
        System.out.print(sb);
        br.close();
    }
}