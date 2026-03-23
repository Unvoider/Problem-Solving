import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    private static final int DISTANCE_LIMIT = 100000000;

    private static class Bus implements Comparable<Bus> {
        int end, cost;
        public Bus(int end, int cost) { this.end = end; this.cost = cost; }
        @Override
        public int compareTo(Bus b) {
            return this.cost - b.cost;
        }
    }

    private static ArrayList<Bus>[] graph;

    private static int dijkstra(int begin, int finish) {
        int size = graph.length;
        int[] costs = new int[size];
        Arrays.fill(costs, DISTANCE_LIMIT); // begin에서부터 다른 노드로의 비용
        PriorityQueue<Bus> pq = new PriorityQueue<>(); // 최소 힙

        costs[begin] = 0; // 자기 자신에 대한 비용
        pq.add(new Bus(begin, 0));

        while(!pq.isEmpty()) {
            int shortestEnd = pq.remove().end; // begin에서부터 가장 비용이 적은 노드 가져오기
            if(shortestEnd == finish) break;
            for(Bus adjacent: graph[shortestEnd]) { // 해당 노드의 인접 노드 확인
                int viaEnd = adjacent.end;
                int viaCost = costs[shortestEnd] + adjacent.cost;
                if(viaCost < costs[viaEnd]) { // 경유했을 때 기존 경로보다 싸면 업데이트 및 추가
                    costs[viaEnd] = viaCost;
                    pq.add(new Bus(viaEnd, viaCost));
                }
            }
        }
        return costs[finish];
    }

    public static void main(String[] args) throws IOException {
        int n, m, begin, finish;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1]; // 방향성 그래프
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Bus(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        begin = Integer.parseInt(st.nextToken());
        finish = Integer.parseInt(st.nextToken());
        System.out.print(dijkstra(begin, finish));
        br.close();
    }
}