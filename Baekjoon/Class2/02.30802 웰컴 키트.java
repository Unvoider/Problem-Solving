import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final int T_SIZE_COUNT = 6;
    public static void main(String[] args) throws IOException {
        int n, t = 0, p, pRest;
        int[] tCounts = new int[T_SIZE_COUNT];
        int tBundle, pBundle;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < T_SIZE_COUNT; i++)
            tCounts[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        tBundle = Integer.parseInt(st.nextToken());
        pBundle = Integer.parseInt(st.nextToken());

        // 티셔츠 묶음
        for(int i = 0; i < T_SIZE_COUNT; i++)
            t += (int)(Math.ceil(tCounts[i] / (double)tBundle));
        // t += (tCounts[i] + tBundle - 1) / tBundle;

        // 펜 묶음과 낱개
        p = n / pBundle;
        pRest = n % pBundle;

        sb.append(t).append('\n').append(p).append(' ').append(pRest);
        System.out.print(sb);
        br.close();
    }
}