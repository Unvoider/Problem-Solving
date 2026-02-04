import java.io.*;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        int h, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        if((m -= 45) < 0) {
            m += 60;
            if((h -= 1) < 0)
                h += 24;
        }
        System.out.print(h + " " + m);
        br.close();
    }
}