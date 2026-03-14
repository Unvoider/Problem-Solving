// 양방향 BFS
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    private static final int MAX_NUM = 9999;
    private static final int DIGIT_LIMIT = 10000;
    private static final int BEGINNING = -1;
    private static final char[] A_OPERATIONS = {'D', 'S', 'L', 'R'};
    private static final char[] B_OPERATIONS = {'D', 'D', 'S', 'L', 'R'};

    private static class Operation {
        char operation;
        int prevIndex;
        public Operation(char operation, int prevIndex) {
            this.operation = operation;
            this.prevIndex = prevIndex;
        }
    }

    // 미리 DSLR 계산
    private static int[][] aDslr = new int[MAX_NUM + 1][4];
    private static int[][] bDslr = new int[MAX_NUM + 1][5];
    private static void initDslr() {
        for(int n = 0; n <= MAX_NUM; n++) {
            aDslr[n][0] = (2 * n) % DIGIT_LIMIT;
            aDslr[n][1] = n == 0 ? MAX_NUM : n - 1;
            aDslr[n][2] = (n * 10) % DIGIT_LIMIT + n / (DIGIT_LIMIT / 10); // shift left + carry
            aDslr[n][3] = (n / 10) + (n % 10) * (DIGIT_LIMIT / 10); // shift right + carry * 1000
            bDslr[n][0] = n / 2;
            bDslr[n][1] = (n + DIGIT_LIMIT) / 2;
            bDslr[n][2] = n == MAX_NUM ? 0 : n + 1;
            bDslr[n][3] = aDslr[n][3]; // shift right + carry * 1000
            bDslr[n][4] = aDslr[n][2]; // shift left + carry
        }
    }

    private static void printTraces(
            int meetingPoint,
            Operation[] aOperations,
            Operation[] bOperations,
            StringBuilder sb
    ) {
        ArrayList<Character> aTrace = new ArrayList<>();
        Operation cur = aOperations[meetingPoint]; // A 역추적
        while(cur.prevIndex != BEGINNING) {
            aTrace.add(cur.operation);
            cur = aOperations[cur.prevIndex];
        }
        for(int i = aTrace.size() - 1; i >= 0; i--)
            sb.append(aTrace.get(i));

        cur = bOperations[meetingPoint]; // B 역추적
        while(cur.prevIndex != BEGINNING) {
            sb.append(cur.operation);
            cur = bOperations[cur.prevIndex];
        }
        sb.append('\n');
    }

    private static void runRegister(BufferedReader br, StringBuilder sb) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a == b) {
            sb.append('\n');
            return;
        }

        Operation[] aOperations = new Operation[MAX_NUM + 1];
        Operation[] bOperations = new Operation[MAX_NUM + 1];
        Deque<Integer> aBfs = new ArrayDeque<>(); // 너비 우선 탐색
        Deque<Integer> bBfs = new ArrayDeque<>();
        aBfs.addLast(a);
        bBfs.addLast(b);
        aOperations[a] = new Operation('\0', BEGINNING);
        bOperations[b] = new Operation('\0', BEGINNING);

        while(true) {
            int levelSize = aBfs.size();
            for(int i = 0; i < levelSize; i++) { // 한 레벨씩
                int start = aBfs.removeFirst();

                // 정방향 탐색
                for(int j = 0; j < 4; j++) {
                    int end = aDslr[start][j];
                    if(aOperations[end] == null) { // 연산자 저장
                        aBfs.addLast(end);
                        aOperations[end] = new Operation(A_OPERATIONS[j], start);
                    }
                    if(bOperations[end] != null) { // 반대편과 만남
                        printTraces(end, aOperations, bOperations, sb);
                        return;
                    }
                }
            }

            levelSize = bBfs.size();
            for(int i = 0; i < levelSize; i++) { // 한 레벨씩
                int start = bBfs.removeFirst();

                // 역방향 탐색
                for(int j = (start % 2 == 0) ? 0 : 2; j < 5; j++) {
                    int end = bDslr[start][j];
                    if(bOperations[end] == null) { // 연산자 저장
                        bBfs.addLast(end);
                        bOperations[end] = new Operation(B_OPERATIONS[j], start);
                    }
                    if(aOperations[end] != null) { // 반대편과 만남
                        printTraces(end, aOperations, bOperations, sb);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        initDslr();

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++)
            runRegister(br, sb);
        System.out.print(sb);
        br.close();
    }
}

/* 단방향 BFS
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
        while(true) {
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
*/