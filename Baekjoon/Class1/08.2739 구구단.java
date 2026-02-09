import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= 9; i++)
            sb.append(n).append(" * ").append(i).append(" = ").append(n * i).append('\n');
        System.out.print(sb);
        br.close();
    }
}