import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n, m = 0, total = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());
            total += score;
            if(score > m)
                m = score;
        }
        System.out.print(((float)total / m * 100) / n);
        br.close();
    }
}