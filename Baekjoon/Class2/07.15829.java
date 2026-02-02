import java.io.*;

class Main {
    private static final int CHAR_START = 'a' - 1;
    private static final long R = 31L, M = 1234567891L;

    private static long getHash(String str, int len) {
        long hash = 0, power = 1L;
        for(int i = 0; i < len; i++) {
            // 오버플로우를 방지하기 위해 hash와 power에 나머지 연산
            hash = (hash + (str.charAt(i) - CHAR_START) * power) % M;
            power = power * R % M;
        }
        return hash;
    }

    public static void main(String[] args) throws IOException {
        int l;
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = Integer.parseInt(br.readLine());
        str = br.readLine();
        System.out.print(getHash(str, l));
        br.close();
    }
}