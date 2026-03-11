import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    private static final int BOARD_SIZE = 100;

    private static int countRolls(int[] laddersAndSnakes) {
        int[] rollCounts = new int[BOARD_SIZE + 1]; // 암시적 그래프
        Deque<Integer> bfs = new ArrayDeque<>();
        bfs.addLast(1); // 시작 위치
        while(!bfs.isEmpty()) {
            int start = bfs.removeFirst();
            for(int move = 1; move <= 6; move++) {
                int end = start + move;
                if(end < BOARD_SIZE && laddersAndSnakes[end] != 0) // 사다리 뱀 타기
                    end = laddersAndSnakes[end];
                if(end <= 0 || end > BOARD_SIZE) // 경계 검사
                    continue;
                if(rollCounts[end] == 0) { // 이동
                    rollCounts[end] = rollCounts[start] + 1;
                    if (end == 100)
                        return rollCounts[end];
                    bfs.addLast(end);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        int n, m;
        int[] laddersAndSnakes = new int[BOARD_SIZE];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            laddersAndSnakes[start] = end;
        }

        System.out.print(countRolls(laddersAndSnakes));
        br.close();
    }
}