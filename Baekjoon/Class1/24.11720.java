import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        int n, total = 0;
        String num;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = br.readLine();
        for(int i = 0; i < n; i++)
            total += num.charAt(i) - '0';
        System.out.print(total);
        br.close();
    }
}