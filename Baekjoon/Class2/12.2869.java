import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static long divCeil(long x, long y) {
        return (x + y - 1) / y;
    }

    public static void main(String[] args) throws IOException {
        long a, b, v;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        // 첫 상승을 제외한 거리: v - a
        // 매일 상승 거리: a - b
        System.out.print(divCeil(v - a, a - b) + 1);
        // 위의 전개식:
        // System.out.print((v - b - 1) / (a - b) + 1);
        br.close();
    }
}