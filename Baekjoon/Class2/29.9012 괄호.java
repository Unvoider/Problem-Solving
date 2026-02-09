import java.io.*;

class Main {
    private static boolean vps(String ps) { // valid parenthesis string
        int count = 0;
        for(char ch: ps.toCharArray())
            if(ch == '(') // 왼쪽 괄호 count++
                count++;
            else // 오른쪽 괄호 count--
                if(count == 0) return false; // count 빔
                else count--;
        return count == 0; // 남은 괄호 없으면 성공
    }

    public static void main(String[] args) throws IOException {
        int t;
        String ps;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++)
            if(vps(br.readLine())) sb.append("YES\n");
            else sb.append("NO\n");
        System.out.print(sb);
        br.close();
    }
}