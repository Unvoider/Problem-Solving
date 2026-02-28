import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n, maxFruit = 0;
        int[] sn;
        int fruitTypes = 0; // 과일 종류
        int[] fruitCounts = new int[10]; // 과일 종류별 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        sn = new int[n]; // 과일 순서
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            sn[i] = Integer.parseInt(st.nextToken());

        int front = 0, rear = 0;
        while(rear < n) {
            int rearFruit = sn[rear++]; // 과일 추가
            if(fruitCounts[rearFruit]++ == 0)
                fruitTypes++;
            while(fruitTypes > 2) { // 두 종류보다 많으면 과일 제거
                int frontFruit = sn[front++];
                if(--fruitCounts[frontFruit] == 0)
                    fruitTypes--;
            }
            maxFruit = Math.max(maxFruit, rear - front); // 최대 개수 업데이트
        }
        System.out.print(maxFruit);
        br.close();
    }
}