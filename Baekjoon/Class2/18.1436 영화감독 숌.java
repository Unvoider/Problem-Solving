import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n, title = 665;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            boolean found = false;
            while(!found) {
                title++;
                int dividend = title, sixCount = 0;
                while(dividend != 0) {
                    if(dividend % 10 == 6) { // 6이 세 번 연속되는 수 찾기
                        sixCount++;
                        if(sixCount == 3)
                            found = true;
                    }
                    else
                        sixCount = 0;
                    dividend /= 10;
                }
            }
        }
        System.out.print(title);
        br.close();
    }
}

/* 문자열 이용
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n, count = 1, title = 665;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        while(count <= n) {
            title++;
            if(String.valueOf(title).contains("666"))
                count++;
        }
        System.out.print(title);
        br.close();
    }
}
*/