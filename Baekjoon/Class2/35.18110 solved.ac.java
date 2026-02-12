import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        int[] opinions;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        if(n == 0)
            System.out.print(0);
        else {
            opinions = new int[n];
            for(int i = 0; i < n; i++)
                opinions[i] = Integer.parseInt(br.readLine());
            Arrays.sort(opinions); // 정렬

            int total = 0;
            int exclusion = (int)Math.round(n * 0.15); // 절사 범위
            for(int i = exclusion; i < n - exclusion; i++) // 절사
                total += opinions[i];
            System.out.print(Math.round((double)total / (n - 2 * exclusion))); // 평균
        }
        br.close();
    }
}