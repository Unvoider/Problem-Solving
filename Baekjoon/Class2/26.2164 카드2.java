import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        Deque<Integer> cards = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++)
            cards.addLast(i);

        while(cards.size() > 1) {
            cards.removeFirst(); // 맨 위 제거
            cards.addLast(cards.removeFirst()); // 맨 위 -> 맨 아래
        }
        System.out.print(cards.peekFirst());
        br.close();
    }
}