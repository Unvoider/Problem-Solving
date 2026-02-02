import java.io.*;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        int n, input, min = 10000001, max = -10000001;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            input = Integer.parseInt(st.nextToken());
            if(input < min) min = input;
            if(input > max) max = input;
        }
        System.out.print(min + " " + max);
        br.close();
    }
}