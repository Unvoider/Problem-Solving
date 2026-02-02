import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n, lastRoom = 1, dist = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        while(n > lastRoom) {
            lastRoom += dist * 6; // 마지막 방 번호가 i * 6씩 증가함
            dist++;
        }
        System.out.print(dist);
        br.close();
    }
}