import java.io.*;

class Main {
    private static final int MAX_NUM = 100;
    public static void main(String[] args) throws IOException {
        int t;
        long[] padovan = new long[MAX_NUM + 1];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        padovan[1] = padovan[2] = padovan[3] = 1; // 타뷸레이션
        padovan[4] = padovan[5] = 2;
        for(int i = 6; i <= MAX_NUM; i++)
            padovan[i] = padovan[i - 5] + padovan[i - 1];

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(padovan[n]).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}