import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n, k, coinCount = 0;
        int[] coins;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n]; // 동전 종류
        for(int i = n - 1; i >= 0; i--)
            coins[i] = Integer.parseInt(br.readLine());

        for(int coin: coins) { // 동전 개수
            if(k == 0) break;
            coinCount += k / coin;
            k %= coin;
        }
        System.out.print(coinCount);
        br.close();
    }
}