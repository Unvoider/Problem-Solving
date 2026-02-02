import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++)
            sb.append(i).append('\n');
        System.out.print(sb.toString());
        br.close();
    }
}