import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int t, r;
        String s;
        StringBuilder p = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            s = st.nextToken();
            for(int j = 0; j < s.length(); j++)
                for(int k = 0; k < r; k++)
                    p.append(s.charAt(j));
            p.append('\n');
        }
        System.out.print(p.toString());
        br.close();
    }
}