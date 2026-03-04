import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n, m;
        char[] s;
        int pCount = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        s = br.readLine().toCharArray();

        for(int i = 0; i < m - n * 2; i++)
            if(s[i] == 'I') { // 시작 문자 찾기
                int oiCount = 0;
                while(i + 2 < m) { // 뒤에 있는 문자 두 개 확인
                    if(s[i + 1] == 'O' && s[i + 2] == 'I') {
                        i += 2;
                        oiCount++;
                        if(oiCount >= n) pCount++;
                    }
                    else
                        break;
                }
            }

        System.out.print(pCount);
        br.close();
    }
}