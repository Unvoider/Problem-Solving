// 에라토스테네스의 체 O(NloglogN)
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static class Sieve {
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

    public static void main(String[] args) throws IOException {
        int n, num, primeCount = 0;
        Sieve sieve = new Sieve(1000);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num = Integer.parseInt(st.nextToken());
            if(sieve.isPrime(num)) primeCount++;
        }
        System.out.print(primeCount);
        br.close();
    }
}

/* 홀수만 찾기
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
        int n, num, primeCount = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num = Integer.parseInt(st.nextToken());
            primeCount += isPrime(num);
        }
        System.out.print(primeCount);
        br.close();
    }
}
*/