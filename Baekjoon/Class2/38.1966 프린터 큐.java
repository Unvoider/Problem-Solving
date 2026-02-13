import java.io.*;
import java.util.*;

class Main {
    private static void runPrinter(BufferedReader br, StringBuilder sb) throws IOException {
        int n, m;
        PriorityQueue<Integer> priorities = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 max heap
        Deque<int[]> printerQueue = new ArrayDeque<>(); // <인덱스, 우선순위>
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) { // 초기화
            int priority = Integer.parseInt(st.nextToken());
            priorities.add(priority);
            printerQueue.addLast(new int[]{i, priority});
        }

        // 우선순위가 높은 것부터 출력
        int order = 1; // 출력 순서
        while(true) {
            int[] frontDoc = printerQueue.removeFirst();
            if(frontDoc[1] == priorities.peek()) { // 해당 우선순위 찾음
                if(frontDoc[0] == m) { // 출력
                    sb.append(order).append('\n');
                    break;
                }
                priorities.remove();
                order++;
            }
            else // 해당 우선순위 못 찾음
                printerQueue.addLast(frontDoc); // 회전
        }
    }

    public static void main(String[] args) throws IOException {
        int testCase;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        testCase = Integer.parseInt(br.readLine());
        for(int t = 0; t < testCase; t++) {
            runPrinter(br, sb);
        }
        System.out.print(sb);
        br.close();
    }
}