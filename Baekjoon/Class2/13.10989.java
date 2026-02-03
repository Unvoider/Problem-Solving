import java.io.*;

class Main {
    private static final int NUM_RANGE = 10001;
    public static void main(String[] args) throws IOException {
        int n;
        int[] numCounts = new int[NUM_RANGE];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) { // 계수 정렬
            int num = Integer.parseInt(br.readLine());
            numCounts[num]++;
        }
        for(int i = 1; i < NUM_RANGE; i++) // 출력
            for(int j = 0; j < numCounts[i]; j++)
                sb.append(i).append('\n');
        System.out.print(sb.toString());
        br.close();
    }
}