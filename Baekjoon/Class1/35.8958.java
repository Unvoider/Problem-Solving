import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int score = 0, total = 0;
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++)
                if(input.charAt(j) == 'O')
                    total += ++score;
                else score = 0;
            sb.append(total).append('\n');
        }
        System.out.print(sb.toString());
        br.close();
    }
}