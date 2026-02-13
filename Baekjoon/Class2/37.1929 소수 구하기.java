// 에라토스테네스의 체 O(NloglogN)
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Sieve {
    private boolean[] isPrime;

    public Sieve(int max) {
        isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i * i <= max; i++) // 2부터 sqrt(max)까지 소수 찾기
            if(isPrime[i])
                for(int j = i * i; j <= max; j += i) // 소수면 제곱부터 배수를 지우기
                    isPrime[j] = false;
    }

    public boolean isPrime(int num) {
        return isPrime[num];
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        int n, m;
        Sieve sieve;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sieve = new Sieve(m);
        for(int i = n; i <= m; i++)
            if(sieve.isPrime(i))
                sb.append(i).append('\n');
        System.out.print(sb);
        br.close();
    }
}