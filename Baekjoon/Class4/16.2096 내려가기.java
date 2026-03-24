import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final int TABLE_SIZE = 3;
    public static void main(String[] args) throws IOException {
        int n;
        int[] maxTable = new int[TABLE_SIZE], prevMaxTable = new int[TABLE_SIZE];
        int[] minTable = new int[TABLE_SIZE], prevMinTable = new int[TABLE_SIZE];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < TABLE_SIZE; i++) // 첫 열
            maxTable[i] = minTable[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < TABLE_SIZE; j++) {
                prevMaxTable[j] = maxTable[j]; // 슬라이딩 윈도우
                prevMinTable[j] = minTable[j];
                maxTable[j] = minTable[j] = Integer.parseInt(st.nextToken()); // 다음 열
            }
            maxTable[0] += Math.max(prevMaxTable[0], prevMaxTable[1]); // 최댓값 누적
            maxTable[1] += Math.max(Math.max(prevMaxTable[0], prevMaxTable[1]), prevMaxTable[2]);
            maxTable[2] += Math.max(prevMaxTable[1], prevMaxTable[2]);
            minTable[0] += Math.min(prevMinTable[0], prevMinTable[1]); // 최솟값 누적
            minTable[1] += Math.min(Math.min(prevMinTable[0], prevMinTable[1]), prevMinTable[2]);
            minTable[2] += Math.min(prevMinTable[1], prevMinTable[2]);
        }

        sb.append(Math.max(Math.max(maxTable[0], maxTable[1]), maxTable[2])).append(' ');
        sb.append(Math.min(Math.min(minTable[0], minTable[1]), minTable[2]));
        System.out.print(sb);
        br.close();
    }
}