import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    private static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
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
        for(int x = 0; x < n; x++) {
            String row = br.readLine();
            campus[x] = row.toCharArray();
            int y = row.indexOf('I'); // 시작점 찾기
            if(y != -1) {
                bfs.addLast(new Point(x, y));
                campus[x][y] = 'X'; // 방문 처리
            }
        }

        while(!bfs.isEmpty()) { // 주변 사람 찾기
            Point start = bfs.removeFirst();
            for (Point moveDir : MOVE_DIR) { // 모든 방향에 대해
                int endX = start.x + moveDir.x;
                int endY = start.y + moveDir.y;
                if (endX < 0 || endX >= n || endY < 0 || endY >= m) // 경계 확인
                    continue;
                switch (campus[endX][endY]) {
                    case 'P': // 사람 발견(fall-through)
                        people++;
                    case 'O': // 빈 공간으로 이동
                        bfs.addLast(new Point(endX, endY));
                        campus[endX][endY] = 'X'; // 방문 처리
                }
            }
        }

        if(people == 0) System.out.print("TT");
        else System.out.print(people);
        br.close();
    }
}