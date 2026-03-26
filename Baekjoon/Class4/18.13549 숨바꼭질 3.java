import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n, k;
        int depthLimit;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] depths;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        depthLimit = Math.max(n, k) * 2;

        depths = new int[depthLimit + 1]; // 0-1 너비 우선 탐색
        Arrays.fill(depths, -1);
        dq.addLast(n); // 시작
        depths[n] = 0;

        while(!dq.isEmpty()) {
            int start = dq.removeFirst();
            if(start == k) break;

            int teleport = start * 2;
            if(teleport <= depthLimit && depths[teleport] == -1) { // 순간 이동
                dq.addLast(teleport);
                depths[teleport] = depths[start];
            }

            for(int walk: new int[]{ start - 1, start + 1 }) // 걷기
                if(walk >= 0 && walk <= depthLimit && depths[walk] == -1) {
                    dq.addLast(walk);
                    depths[walk] = depths[start] + 1;
                }
        }

        System.out.print(depths[k]);
        br.close();
    }
}