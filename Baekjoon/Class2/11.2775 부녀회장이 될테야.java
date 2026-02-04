import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int t, k, n;
        int[][] apt = new int[15][15]; // 타뷸레이션
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 15; i++) {
            apt[0][i] = i + 1; // 0층 초기화
            apt[i][0] = 1; // 1호 초기화
        }
        for(int i = 1; i < 15; i++) // 전체 계산
            for(int j = 1; j < 15; j++)
                apt[i][j] = apt[i - 1][j] + apt[i][j - 1]; // 아랫집 + 왼쪽 집

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            sb.append(apt[k][n - 1]).append('\n');
        }
        System.out.print(sb.toString());
        br.close();
    }
}