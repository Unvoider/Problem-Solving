import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        int[] nums;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(br.readLine());
        Arrays.sort(nums);
        for(int num: nums)
            sb.append(num).append('\n');
        System.out.print(sb);
        br.close();
    }
}