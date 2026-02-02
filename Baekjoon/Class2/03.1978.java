import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static int isPrime(int num) {
        if(num <= 1) return 0;
        if(num == 2) return 1;
        if(num % 2 == 0) return 0;
        for(int i = 3; i * i <= num; i += 2)
            if(num % i == 0) return 0;
        return 1;
    }

    public static void main(String[] args) throws IOException {
        int n, num, primeN = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num = Integer.parseInt(st.nextToken());
            primeN += isPrime(num);
        }
        System.out.print(primeN);
        br.close();
    }
}