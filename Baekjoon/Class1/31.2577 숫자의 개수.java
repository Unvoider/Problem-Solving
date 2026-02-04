import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        int a, b, c, product, remainder;
        int[] count = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        product = a * b * c;
        while(product != 0) {
            remainder = product % 10;
            count[remainder]++;
            product /= 10;
        }
        for(int i = 0; i < 10; i++)
            sb.append(count[i]).append('\n');
        System.out.print(sb.toString());
        br.close();
    }
}