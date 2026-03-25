import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n, k;
        int[] maxAccVals;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        maxAccVals = new int[k + 1]; // 가방 용량에 따른 모든 물건 가치 누적
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            for(int j = k; j >= w; j--) // i번째 물건이 중복 처리되는 것을 방지하기 위해 역순으로 처리
                // 해당 물건을 넣지 않았을 때의 최댓값과, 해당 물건을 넣었을 때 나머지 용량에 넣을 수 있는 최댓값 비교
                maxAccVals[j] = Math.max(maxAccVals[j], v + maxAccVals[j - w]);
        }

        System.out.print(maxAccVals[k]);
        br.close();
    }
}