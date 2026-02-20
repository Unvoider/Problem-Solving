import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int total = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer expr = new StringTokenizer(br.readLine(), "-");

        for(boolean isPlus = true; expr.hasMoreTokens(); isPlus = false) {
            StringTokenizer terms = new StringTokenizer(expr.nextToken(), "+");
            int termsTotal = 0;
            while(terms.hasMoreTokens())
                termsTotal += Integer.parseInt(terms.nextToken());
            if(isPlus) // '-'가 나오기 전까지 더하기
                total += termsTotal;
            else // '-'가 나오면 빼기
                total -= termsTotal;
        }
        System.out.print(total);
        br.close();
    }
}