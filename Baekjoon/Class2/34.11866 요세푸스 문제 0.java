import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n, k;
        Deque<Integer> people = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++)
            people.addLast(i);

        sb.append('<');
        while(true) {
            for(int i = k; i > 1; i--) // k - 1번 이동
                people.addLast(people.removeFirst());
            sb.append(people.removeFirst()); // k번째 사람
            if(people.isEmpty()) break;
            sb.append(", ");
        }
        sb.append('>');

        System.out.print(sb);
        br.close();
    }
}