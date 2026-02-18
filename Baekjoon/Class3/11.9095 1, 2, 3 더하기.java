import java.io.*;

class Main {
    private static final int MAX_NUM = 10;
    public static void main(String[] args) throws IOException {
        int t;
        int[] sumCounts = new int[MAX_NUM + 1];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 타뷸레이션
        sumCounts[1] = 1; // 1
        sumCounts[2] = 2; // 1 + 1, 2
        sumCounts[3] = 4; // 1 + 1 + 1, 1 + 2, 2 + 1, 3
        for(int i = 4; i <= MAX_NUM; i++)
            sumCounts[i] = sumCounts[i - 3] + sumCounts[i - 2] + sumCounts[i - 1];

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(sumCounts[n]).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}