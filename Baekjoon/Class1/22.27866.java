import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        String s;
        int i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        i = Integer.parseInt(br.readLine());
        System.out.print(s.charAt(i - 1));
        br.close();
    }
}