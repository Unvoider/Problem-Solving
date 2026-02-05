import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n, fiveCount = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        // 곱해진 10(2 * 5의 쌍) 개수 세기
        // 소인수분해 시 항상 2보다 5가 적으므로 5의 개수만 세면 됨
        for(int i = 5; i <= n; i *= 5)
            fiveCount += n / i;
        System.out.print(fiveCount);
        br.close();
    }
}