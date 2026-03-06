import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static int getZOrder(int size, int row, int col) {
        if(size == 2) // 종료 조건
            return row * 2 + col;

        int half = size >> 1;
        // half 제곱 * 사분면 Z 위치 + 재귀 호출
        return half * half * ((row < half ? 0 : 1) * 2 + (col < half ? 0 : 1))
                + getZOrder(half, row < half ? row : row - half, col < half ? col : col - half);
    }

    public static void main(String[] args) throws IOException {
        int n, r, c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.print(getZOrder(1 << n, r, c));
        br.close();
    }
}