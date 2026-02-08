// 유클리트 호제법
import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static int gcd(int a, int b) { // greatest common divisor
        int r = -1;
        while(r != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static int lcm(int a, int b) { // least common multiple
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        int a, b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        System.out.print(gcd(a, b) + "\n" + lcm(a, b));
        br.close();
    }
}