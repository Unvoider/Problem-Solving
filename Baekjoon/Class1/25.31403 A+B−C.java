import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        int a, b, c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        sb.append(a + b - c).append('\n');
        sb.append(Integer.parseInt(String.valueOf(a) + String.valueOf(b)) - c).append('\n');
        System.out.print(sb);
        br.close();
    }
}