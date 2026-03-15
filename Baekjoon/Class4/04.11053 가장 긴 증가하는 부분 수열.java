import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        int[] a, maxLengths;
        int maxLength = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        maxLengths = new int[n];
        Arrays.fill(maxLengths, 1);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            for(int j = 0; j < i; j++) // 각 도착점의 최대 길이 찾기
                if(a[i] > a[j])
                    maxLengths[i] = Math.max(maxLengths[i], maxLengths[j] + 1);
            if(maxLengths[i] > maxLength) // 전체 도착점 중 최대 길이 찾기
                maxLength = Math.max(maxLength, maxLengths[i]);
        }

        System.out.print(maxLength);
        br.close();
    }
}