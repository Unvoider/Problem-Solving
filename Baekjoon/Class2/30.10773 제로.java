import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    public static void main(String[] args) throws IOException {
        int k;
        long total = 0;
        Deque<Integer> nums = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) nums.pop(); // 0이면 pop
            else nums.push(num);
        }
        while(!nums.isEmpty())
            total += nums.pop();
        System.out.print(total);
        br.close();
    }
}