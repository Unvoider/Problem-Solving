import java.io.*;
import java.util.*;

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
    private static final char HOUSE = '1';
    private static final char EMPTY = '0';

    public static void main(String[] args) throws IOException {
        int n;
        char[][] houses;
        ArrayList<Integer> houseCounts = new ArrayList<>();
        Deque<Point> bfs = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        houses = new char[n][];
        for(int i = 0; i < n; i++)
            houses[i] = br.readLine().toCharArray();

        for(int x = 0; x < n; x++) // 너비 우선 탐색
            for(int y = 0; y < n; y++)
                if(houses[x][y] == HOUSE) { // 집이 있음
                    int houseCount = 1;
                    bfs.addLast(new Point(x, y));
                    houses[x][y] = EMPTY;
                    while(!bfs.isEmpty()) { // 인접한 집 확인
                        Point start = bfs.removeFirst();
                        for(Point moveDir: MOVE_DIR) {
                            int endX = start.x + moveDir.x;
                            int endY = start.y + moveDir.y;
                            if(endX < 0 || endX >= n || endY < 0 || endY >= n)
                                continue;
                            if(houses[endX][endY] == HOUSE) { // 인접한 집이 있음
                                houseCount++;
                                bfs.addLast(new Point(endX, endY));
                                houses[endX][endY] = EMPTY;
                            }
                        }
                    }
                    houseCounts.add(houseCount);
                }

        Collections.sort(houseCounts); // 오름차순 정렬
        sb.append(houseCounts.size()).append('\n'); // 단지 수
        for(int houseCount: houseCounts) // 단지당 집 수
            sb.append(houseCount).append('\n');
        System.out.print(sb);
        br.close();
    }
}