// PriorityQueue 사용
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    private static class Pair {
        int num, index;
        public Pair(int num, int index) { this.num = num; this.index = index; }
    }

    private static void runDualPriorityQueue(BufferedReader br, StringBuilder sb) throws IOException {
        int k = Integer.parseInt(br.readLine());

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.num, b.num));
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.num, a.num));
        boolean[] visited = new boolean[k];

        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            switch(operation.charAt(0)) {
                case 'I': // 삽입
                    minHeap.add(new Pair(num, i));
                    maxHeap.add(new Pair(num, i));
                    break;
                case 'D':
                    if(num == -1) { // 최솟값 삭제
                        while(!minHeap.isEmpty()) {
                            if(visited[minHeap.peek().index]) { // 방문했던 노드 삭제
                                minHeap.remove();
                                continue;
                            }
                            visited[minHeap.peek().index] = true;
                            minHeap.remove();
                            break;
                        }
                    }
                    else { // 최댓값 삭제
                        while(!maxHeap.isEmpty()) {
                            if(visited[maxHeap.peek().index]) { // 방문했던 노드 삭제
                                maxHeap.remove();
                                continue;
                            }
                            visited[maxHeap.peek().index] = true;
                            maxHeap.remove();
                            break;
                        }
                    }
            }
        }
        while(!minHeap.isEmpty() && visited[minHeap.peek().index]) minHeap.remove();
        while(!maxHeap.isEmpty() && visited[maxHeap.peek().index]) maxHeap.remove();

        if(minHeap.isEmpty())
            sb.append("EMPTY\n");
        else
            sb.append(maxHeap.peek().num).append(' ').append(minHeap.peek().num).append('\n'); // 최댓값 최솟값 출력
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++)
            runDualPriorityQueue(br, sb);
        System.out.print(sb);
        br.close();
    }
}

/* TreeMap 사용
import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    private static void runDualPriorityQueue(BufferedReader br, StringBuilder sb) throws IOException {
        int k = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> q = new TreeMap<>(); // <num, count>
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            switch(operation.charAt(0)) {
                case 'I': // 삽입
                    q.put(num, q.getOrDefault(num, 0) + 1);
                    break;
                case 'D': // 삭제
                    if(q.isEmpty())
                        break;
                    int numToRemove = (num == -1) ? q.firstKey() : q.lastKey(); // 최댓값 : 최솟값
                    int count = q.get(numToRemove);
                    if(count == 1)
                        q.remove(numToRemove);
                    else
                        q.put(numToRemove, count - 1);
            }
        }

        if(q.isEmpty())
            sb.append("EMPTY\n");
        else
            sb.append(q.lastKey()).append(' ').append(q.firstKey()).append('\n');
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++)
            runDualPriorityQueue(br, sb);
        System.out.print(sb);
        br.close();
    }
}
*/