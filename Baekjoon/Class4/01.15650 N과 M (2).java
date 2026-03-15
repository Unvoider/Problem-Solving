import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static int n, m;
    private static boolean[] visited;
    private static int[] track;
    private static StringBuilder sb = new StringBuilder();

    private static void backTrack(int start, int depth) {
        if(depth == m) { // 출력
            for(int num : track)
                sb.append(num).append(' ');
            sb.append('\n');
            return;
        }
        for(int i = start; i <= n; i++) {
            if(!visited[i]) {
                track[depth] = i; // 추가
                visited[i] = true;
                backTrack(i + 1, depth + 1);
                visited[i] = false; // 삭제
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        track = new int[m];
        visited = new boolean[n + 1];
        backTrack(1, 0);
        System.out.print(sb);
        br.close();
    }
}