import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n, minTotal = 0;
        int[] timeArr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        timeArr = new int[n]; // 인출하는 데 걸리는 시간
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            timeArr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(timeArr); // 정렬

        for(int i = 0; i < n; i++) // 시간 합의 최솟값
            minTotal += timeArr[i] * (n - i);
        System.out.print(minTotal);
        br.close();
    }
}