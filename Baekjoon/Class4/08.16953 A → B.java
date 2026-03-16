import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int a, b;
        int depth = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        while(b > a) {
            if(b % 2 == 0) // 2를 곱한다
                b >>= 1;
            else if(b % 10 == 1) // 1을 수의 가장 오른쪽에 추가한다
                b /= 10;
            else // 미리 종료
                break;
            depth++;
        }

        System.out.print(a == b ? depth : -1);
        br.close();
    }
}