import java.io.*;
import java.util.*;

class Main {
    private static StringBuilder sb;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    // 깊이 우선 탐색
    private static void dfsRecursive(int start) {
        visited[start] = true;
        sb.append(start).append(' ');
        for(int end: graph[start])
            if(!visited[end]) {
                dfsRecursive(end);
            }
    }
    private static void dfs(int start) {
        visited = new boolean[graph.length];
        dfsRecursive(start);
        sb.append('\n');
    }

    // 너비 우선 탐색
    private static void bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        visited = new boolean[graph.length];
        deque.addLast(start);
        visited[start] = true;
        sb.append(start).append(' ');
        while(!deque.isEmpty()) {
            start = deque.removeFirst();
            for(int end: graph[start])
                if(!visited[end]) {
                    deque.addLast(end);
                    visited[end] = true;
                    sb.append(end).append(' ');
                }
        }
        sb.append('\n');
    }

    public static void main(String[] args) throws IOException {
        int n, m, v;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1]; // 무방향성 그래프
        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
        for(int i = 1; i <= n; i++) // 정렬
            Collections.sort(graph[i]);

        dfs(v);
        bfs(v);

        System.out.print(sb);
        br.close();
    }
}