import java.io.*;

class Main {
    private static final int DIVISOR = 10007;
    public static void main(String[] args) throws IOException {
        int n;
        int[] tilingCases;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        tilingCases = new int[n + 1]; // 타뷸레이션
        if(n >= 1) tilingCases[1] = 1;
        if(n >= 2) tilingCases[2] = 2;
        for(int i = 3; i <= n; i++)
            tilingCases[i] = (tilingCases[i - 2] + tilingCases[i - 1]) % DIVISOR;

        System.out.print(tilingCases[n]);
        br.close();
    }
}