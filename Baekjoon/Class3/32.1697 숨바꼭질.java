import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    private static final int MAX_POS = 100000;
    private static class HideAndSeek {
        private int seekTime;

        public HideAndSeek(int seeker, int hider) {
            Deque<Integer> bfs = new ArrayDeque<>();
            int[] depths = new int[MAX_POS + 1];
            Arrays.fill(depths, -1);

            bfs.addLast(seeker); // 너비 우선 탐색
            depths[seeker] = 0;
            while(true) {
                int start = bfs.removeFirst();
                if(start == hider) // 찾음
                    break;
                int[] ends = { start - 1, start + 1, start * 2 }; // 못 찾음
                for (int end : ends) {
                    if(end >= 0 && end <= MAX_POS && depths[end] == -1) {
                        bfs.addLast(end);
                        depths[end] = depths[start] + 1;
                    }
                }
            }

            seekTime = depths[hider];
        }
        public int getSeekTime() {
            return seekTime;
        }
    }

    public static void main(String[] args) throws IOException {
        int n, k;
        HideAndSeek hideAndSeek;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.print(new HideAndSeek(n, k).getSeekTime());
        br.close();
    }
}