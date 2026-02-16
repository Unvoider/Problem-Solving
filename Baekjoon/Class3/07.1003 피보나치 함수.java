// 반복 동적 프로그래밍
import java.io.*;

class Main {
    private static final int FIB_MAX = 40;
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 타뷸레이션
        int[] zeroCount = new int[FIB_MAX + 2];
        zeroCount[0] = 1;
        for(int i = 2; i < FIB_MAX + 2; i++)
            zeroCount[i] = zeroCount[i - 1] + zeroCount[i - 2];

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(zeroCount[n]).append(' ').append(zeroCount[n + 1]).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}

/* 재귀 동적 프로그래밍
import java.io.*;

class Main {
    private static final int FIB_MAX = 40;

    // 메모이제이션
    private static int[] zeroCount = new int[FIB_MAX + 2];

    private static void countFib(int n) {
        if(n < 2) return;
        if(zeroCount[n] != 0) return;
        countFib(n - 1);
        countFib(n - 2);
        zeroCount[n] = zeroCount[n - 1] + zeroCount[n - 2];
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 초기화
        zeroCount[0] = 1;

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            countFib(n + 1);
            sb.append(zeroCount[n]).append(' ').append(zeroCount[n + 1]).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
*/