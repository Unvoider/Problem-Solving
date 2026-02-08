// 반복 동적 프로그래밍
import java.io.*;
import java.util.Arrays;

class Main {
    private static final int INF = 5001;

    public static void main(String[] args) throws IOException {
        int n;
        int[] bagCounts;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        bagCounts = new int[n + 1]; // 타뷸레이션
        Arrays.fill(bagCounts, INF);
        bagCounts[3] = 1;
        if(n >= 5) bagCounts[5] = 1;

        for(int i = 6; i <= n; i++)
            bagCounts[i] = Math.min(bagCounts[i - 3], bagCounts[i - 5]) + 1; // 더 적은 봉지 수에 하나 추가

        if(bagCounts[n] >= INF) System.out.print("-1");
        else System.out.print(bagCounts[n]);
        br.close();
    }
}

/* 그리디
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n, bagCount = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int fiveKg = n / 5; fiveKg >= 0; fiveKg--) { // 5kg 봉지 최대부터 0개까지
            int remain = n - (5 * fiveKg);
            if(remain % 3 == 0) { // 나머지가 3으로 나눠 떨어지면 종료
                bagCount = fiveKg + (remain / 3);
                break;
            }
        }
        System.out.print(bagCount);
        br.close();
    }
}
*/

/* 재귀 동적 프로그래밍
import java.io.*;
import java.util.Arrays;

class Main {
    private static final int INF = 5001;

    private static int countBags(int kg, int[] bagCounts) {
        if(kg <= 5) return bagCounts[kg];
        if(bagCounts[kg] == INF) // 아직 계산 안 됨
            // 더 적은 봉지 수에 하나 추가
            bagCounts[kg] = Math.min(countBags(kg - 3, bagCounts), countBags(kg - 5, bagCounts)) + 1;
        return bagCounts[kg];
    }

    public static void main(String[] args) throws IOException {
        int n;
        int[] bagCounts;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        bagCounts = new int[n + 1]; // 메모이제이션
        Arrays.fill(bagCounts, INF);
        bagCounts[3] = 1;
        if(n >= 5) bagCounts[5] = 1;

        int bagCount = countBags(n, bagCounts);
        if(bagCount >= INF) System.out.print("-1");
        else System.out.print(bagCount);
        br.close();
    }
}
*/