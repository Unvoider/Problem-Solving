import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        int[][] triangle;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        triangle = new int[n][]; // 삼각형 입력
        for(int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++)
                triangle[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = n - 1; i > 0; i--) // 맨아래 레벨부터 더 큰 자식 누적하기
            for(int j = 0; j < i; j++)
                triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);

        System.out.print(triangle[0][0]);
        br.close();
    }
}