import java.io.*;
import java.util.Arrays;

class Main {
    private static final int CHAR_RANGE = 26;
    public static void main(String[] args) throws IOException {
        int[] firstAppearance = new int[CHAR_RANGE];
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        s = br.readLine();
        Arrays.fill(firstAppearance, -1);
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(firstAppearance[index] == -1)
                firstAppearance[index] = i;
        }
        for(int i = 0; i < CHAR_RANGE; i++)
            sb.append(firstAppearance[i]).append(' ');
        System.out.print(sb.toString());
        br.close();
    }
}