import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    private static final int DIST_LIMIT = 500000000;
    private static class Edge implements Comparable<Edge> {
        int end, weight;
        public Edge(int end, int weight) { this.end = end; this.weight = weight; }
        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    private static ArrayList<Edge>[] graph;

    private static int dijkstra(int begin, int finish) {
        int size = graph.length;
        int[] dists = new int[size]; // begin에서부터 다른 노드로의 거리
        Arrays.fill(dists, DIST_LIMIT);
        PriorityQueue<Edge> pq = new PriorityQueue<>(); // 최소 힙

        dists[begin] = 0; // 자기 자신에 대한 거리
        pq.add(new Edge(begin, 0));

        while(!pq.isEmpty()) {
            int shortestEnd = pq.remove().end; // begin에서부터 가장 거리가 짧은 노드 가져오기
            if(shortestEnd == finish) break;
            for(Edge adjacent: graph[shortestEnd]) { // 해당 노드의 인접 노드 확인
                int viaEnd = adjacent.end;
                int viaDist = dists[shortestEnd] + adjacent.weight;
                if(viaDist < dists[viaEnd]) { // 경유했을 때 기존 경로보다 짧으면 업데이트 및 추가
                    dists[viaEnd] = viaDist;
                    pq.add(new Edge(viaEnd, viaDist));
                }
            }
        }
        return dists[finish];
    }

    public static void main(String[] args) throws IOException {
        int n, e, v1, v2, fromV1ToV2, fromV2ToV1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1]; // 무방향성 그래프
        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        fromV1ToV2 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
        fromV2ToV1 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);
        if(fromV1ToV2 >= DIST_LIMIT && fromV2ToV1 >= DIST_LIMIT) // 경로 없음
            System.out.print(-1);
        else // v1, v2를 경유
            System.out.print(Math.min(fromV1ToV2, fromV2ToV1));
        br.close();
    }
}