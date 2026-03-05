import java.io.*;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        PriorityQueue<Integer> q = new PriorityQueue<>((n1, n2) -> {
            int abs1 = Math.abs(n1), abs2 = Math.abs(n2);
            if(abs1 == abs2)
                return n1 - n2;
            return abs1 - abs2;
        }); // 절댓값 최소 힙
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int x;
            x = Integer.parseInt(br.readLine());
            if(x == 0) // 팝
                if(q.isEmpty()) // 빔
                    sb.append("0\n");
                else
                    sb.append(q.remove()).append('\n');
            else // 푸시
                q.add(x);
        }
        System.out.print(sb);
        br.close();
    }
}