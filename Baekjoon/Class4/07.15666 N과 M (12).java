import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static int n, m;
    private static int[] track;
    private static int[] nums;
    private static StringBuilder sb = new StringBuilder();

    private static void backTrack(int start, int depth) {
        if(depth == m) { // 출력
            for(int num : track)
                sb.append(num).append(' ');
            sb.append('\n');
            return;
        }
        for(int i = start; i < nums.length; i++) {
            track[depth] = nums[i]; // 추가
            backTrack(i, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        track = new int[m];
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        nums = Arrays.stream(nums)
                .sorted() // 정렬
                .distinct() // 중복 제거
                .toArray();

        backTrack(0, 0);
        System.out.print(sb);
        br.close();
    }
}