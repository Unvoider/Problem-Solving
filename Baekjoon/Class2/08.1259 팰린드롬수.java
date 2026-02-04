import java.io.*;

class Main {
    private static boolean isPalindrome(final String str) {
        final int len = str.length();
        for(int i = 0; i < len / 2; i++) // 절반까지 비교
            if(str.charAt(i) != str.charAt(len - 1 - i))
                return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if(str.equals("0")) break;
            if(isPalindrome(str))
                sb.append("yes\n");
            else
                sb.append("no\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}