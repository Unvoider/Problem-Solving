import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        int input, max = -1, maxIndex = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 9; i++) {
            input = Integer.parseInt(br.readLine());
            if(input > max) {
                max = input;
                maxIndex = i;
            }
        }
        sb.append(max).append('\n');
        sb.append(maxIndex).append('\n');
        System.out.print(sb);
        br.close();
    }
}