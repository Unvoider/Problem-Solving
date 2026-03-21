import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] scores = new int[2][n];

            for(int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k < n; k++)
                    scores[j][k] = Integer.parseInt(st.nextToken());
            }

            if(n != 1) {
                scores[0][1] += scores[1][0]; // 위 뗌
                scores[1][1] += scores[0][0]; // 아래 뗌
                for(int j = 2; j < n; j++) {
                    scores[0][j] += Math.max(scores[1][j - 1], scores[1][j - 2]); // 위 뗌
                    scores[1][j] += Math.max(scores[0][j - 1], scores[0][j - 2]); // 아래 뗌
                }
            }

            sb.append(Math.max(scores[0][n - 1], scores[1][n - 1])).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}