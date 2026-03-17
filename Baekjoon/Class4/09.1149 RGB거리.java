import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        int r, g, b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        for(int i = 1; i < n; i++) {
            int prevR = r, prevG = g, prevB = b;

            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            r += Math.min(prevG, prevB); // 다른 색 중 최솟값 더하기
            g += Math.min(prevR, prevB);
            b += Math.min(prevR, prevG);
        }

        System.out.print(Math.min(Math.min(r, g), b));
        br.close();
    }
}

/* 확장 가능
import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final int COLOR_TYPES = 3;
    private static final int MAX_COST = 10000000;
    public static void main(String[] args) throws IOException {
        int n;
        int[] colors = new int[COLOR_TYPES];
        int[] prevColors = new int[COLOR_TYPES];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < COLOR_TYPES; i++)
            colors[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < COLOR_TYPES; j++) {
                prevColors[j] = colors[j];
                colors[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 0; j < COLOR_TYPES; j++) { // 다른 색 중 최솟값 더하기
                int prevMinCost = MAX_COST;
                for(int k = 0; k < COLOR_TYPES; k++)
                    if(j != k)
                        prevMinCost = Math.min(prevMinCost, prevColors[k]);
                colors[j] += prevMinCost;
            }
        }

        int totalMinCost = colors[0];
        for(int i = 1; i < COLOR_TYPES; i++)
            totalMinCost = Math.min(totalMinCost, colors[i]);
        System.out.print(totalMinCost);
        br.close();
    }
}
*/