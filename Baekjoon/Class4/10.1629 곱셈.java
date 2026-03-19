import java.io.*;
import java.util.StringTokenizer;

/*
a^n
= a if n==1,
= (a^(n/2))^2 if n%2==0,
= a*(a^((n-1)/2))^2 if n%2==1
*/

class Main {
    private static long powerMod(long base, long exp, long div) {
        if(exp == 1) return base % div; // 1일 때
        long half = powerMod(base, exp / 2, div);
        long whole = (half * half) % div;
        if(exp % 2 == 0) return whole; // 짝수일 때
        return ((base % div) * whole) % div; // 홀수일 때
    }

    public static void main(String[] args) throws IOException {
        int a, b, c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.print(powerMod(a, b, c));
        br.close();
    }
}