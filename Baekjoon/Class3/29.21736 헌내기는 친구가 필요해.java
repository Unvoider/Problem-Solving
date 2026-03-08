import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    private static class Point {
        int r, c;
        Point(int r, int c) { this.r = r; this.c = c; }
    }
    private static final Point[] MOVE_DIR = {
            new Point(-1, 0),
            new Point(1, 0),
            new Point(0, -1),
            new Point(0, 1)
    };

    public static void main(String[] args) throws IOException {
        int n, m, people = 0;
        char[][] campus;
        Deque<Point> bfs = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        campus = new char[n][m];
        for(int r = 0; r < n; r++) {
            String row = br.readLine();
            campus[r] = row.toCharArray();
            int c = row.indexOf('I'); // 시작점 찾기
            if(c != -1) {
                bfs.addLast(new Point(r, c));
                campus[r][c] = 'X'; // 방문 처리
            }
        }

        while(!bfs.isEmpty()) { // 주변 사람 찾기
            Point start = bfs.removeFirst();
            for (Point moveDir : MOVE_DIR) { // 모든 방향에 대해
                int endR = start.r + moveDir.r;
                int endC = start.c + moveDir.c;
                if (endR < 0 || endR >= n || endC < 0 || endC >= m) // 경계 확인
                    continue;
                switch (campus[endR][endC]) {
                    case 'P': // 사람 발견(fall-through)
                        people++;
                    case 'O': // 빈 공간으로 이동
                        bfs.addLast(new Point(endR, endC));
                        campus[endR][endC] = 'X'; // 방문 처리
                }
            }
        }

        if(people == 0) System.out.print("TT");
        else System.out.print(people);
        br.close();
    }
}