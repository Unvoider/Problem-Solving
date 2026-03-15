import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static int n, m;
    private static boolean[] visited;
    private static int[] track;
    private static int[] nums;
    private static StringBuilder sb = new StringBuilder();

    private static void backTrack(int depth) {
        if(depth == m) { // 출력
            for(int num : track)
                sb.append(num).append(' ');
            sb.append('\n');
            return;
        }
        int prevNum = -1;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                int curNum = nums[i];
                if(prevNum == curNum) continue; // 해당 깊이 직전 숫자와 같으면 건너뛰기
                else prevNum = curNum;
                track[depth] = curNum; // 추가
                visited[i] = true;
                backTrack(depth + 1);
                visited[i] = false; // 삭제
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        track = new int[m];
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums); // 정렬

        backTrack(0);
        System.out.print(sb);
        br.close();
    }
}