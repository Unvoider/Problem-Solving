import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        int[] countTable;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // 타뷸레이션
        countTable = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            int a, b, c;
            a = b = c = countTable[i - 1] + 1;
            if (i % 3 == 0) b = countTable[i / 3] + 1; // 3으로 나눠 떨어지면
            if (i % 2 == 0) c = countTable[i / 2] + 1; // 2로 나눠 떨어지면
            countTable[i] = Math.min(a, Math.min(b, c));
        }
        System.out.print(countTable[n]);
        br.close();
    }
}