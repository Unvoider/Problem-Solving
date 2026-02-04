import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n, out = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        // 999999의 각 자리를 모두 더해도 기껏해야 54가 나오므로 N - 54부터 시작함
        for(int i = (Math.max(n - 54, 0)); i < n; i++) {
            int num = i, total = i;
            while(num != 0){
                total += num % 10; // 각 자리 수 더하기
                num /= 10;
            }
            if(total == n) { // 찾음
                out = i;
                break;
            }
        }
        System.out.print(out);
        br.close();
    }
}