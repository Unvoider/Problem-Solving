import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        boolean isAscending = true, isDescending = true;
        int prev, cur;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        prev = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()) {
            cur = Integer.parseInt(st.nextToken());
            if (prev >= cur) isAscending = false;
            if (prev <= cur) isDescending = false;
            prev = cur;
        }
        if(isAscending) System.out.print("ascending");
        else if(isDescending) System.out.print("descending");
        else System.out.print("mixed");
        br.close();
    }
}