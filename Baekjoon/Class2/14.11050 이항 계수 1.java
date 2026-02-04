import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static int binomialCoefficient(int n, int k) {
        int result = 1;
        if(k > n / 2) // k가 n의 절반보다 크면 n - k로 교체
            k = n - k;
        for(int i = 1; i <= k; i++) {
            result *= n + 1 - i;
            result /= i;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        int n, k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        System.out.print(binomialCoefficient(n, k));
        br.close();
    }
}