import java.io.*;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        int input, total = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            input = Integer.parseInt(st.nextToken());
            total += input * input;
        }
        System.out.print(total % 10);
        br.close();
    }
}