import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    private static final int MAX_NUM = 9999;
    private static final int DIGIT_LIMIT = 10000;
    private static final int BEGINNING = -1;
    private static final char[] OPERATIONS = {'D', 'S', 'L', 'R'};

    private static class Operation {
        char operation;
        int prevIndex;
        public Operation(char operation, int prevIndex) {
            this.operation = operation;
            this.prevIndex = prevIndex;
        }
    }

    private static void runRegister(BufferedReader br, StringBuilder sb) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Operation[] operations = new Operation[MAX_NUM + 1];
        Deque<Integer> bfs = new ArrayDeque<>(); // 너비 우선 탐색
        bfs.addLast(a);
        operations[a] = new Operation('\0', BEGINNING);
        while(!bfs.isEmpty()) {
            int start = bfs.removeFirst();

            int[] ends = { // DSLR 계산
                    (2 * start) % DIGIT_LIMIT,
                    start == 0 ? MAX_NUM : start - 1,
                    (start * 10) % DIGIT_LIMIT + start / (DIGIT_LIMIT / 10), // shift left + carry
                    (start / 10) + (start % 10) * (DIGIT_LIMIT / 10) // shift right + carry * 1000
            };

            for(int i = 0; i < ends.length; i++) {
                int end = ends[i];
                if(operations[end] == null) { // 연산자 저장
                    bfs.addLast(end);
                    operations[end] = new Operation(OPERATIONS[i], start);
                }
                if(end == b) { // B 도착
                    ArrayList<Character> trace = new ArrayList<>();
                    Operation cur = operations[end]; // 역추적
                    while(cur.prevIndex != BEGINNING) {
                        trace.add(cur.operation);
                        cur = operations[cur.prevIndex];
                    }
                    for(int j = trace.size() - 1; j >= 0; j--)
                        sb.append(trace.get(j));
                    sb.append('\n');
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++)
            runRegister(br, sb);
        System.out.print(sb);
        br.close();
    }
}