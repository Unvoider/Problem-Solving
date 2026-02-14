import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        Deque<Integer> numDeque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        numDeque.push(0); // top 접근을 위한 더미 데이터
        int numToPush = 1;
        for(int i = 0; i < n; i++) { // n번 pop
            int numToPop = Integer.parseInt(br.readLine());
            while(numDeque.peek() < numToPop) { // pop할 숫자가 없으면
                numDeque.push(numToPush++); // push하기
                sb.append("+\n");
            }
            if(numDeque.peek() > numToPop) { // top이 pop할 숫자 초과(실패)
                sb.setLength(0);
                sb.append("NO");
                break;
            }
            numDeque.pop(); // pop할 숫자 찾음
            sb.append("-\n");
        }
        System.out.print(sb);
        br.close();
    }
}