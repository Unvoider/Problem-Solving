import java.io.*;

class Main {
    private static boolean isSquare(int n) { // 제곱수인지 확인
        int root = (int)Math.sqrt(n);
        return root * root == n;
    }

    public static void main(String[] args) throws IOException {
        int n, powerMax, powers[];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        br.close();

        powerMax = (int)Math.sqrt(n);

        powers = new int[powerMax + 1]; // 타뷸레이션
        for(int i = 1; i <= powerMax; i++)
            powers[i] = i * i;

        if(powers[powerMax] == n) { // 1개
            System.out.print(1);
            return;
        }

        for(int i = 1; i <= powerMax; i++) { // 2개
            int remainder = n - powers[i];
            if(remainder < 1)
                break;
            if(isSquare(remainder)) {
                System.out.print(2);
                return;
            }
        }

        for(int i = 1; i <= powerMax; i++) // 3개
            for(int j = 1; j <= i; j++) {
                int remainder = n - powers[i] - powers[j];
                if (remainder < 1)
                    break;
                if(isSquare(remainder)) {
                    System.out.print(3);
                    return;
                }
            }

        System.out.print(4); // 4개
    }
}