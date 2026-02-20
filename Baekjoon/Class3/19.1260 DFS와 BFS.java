import java.io.*;
import java.util.*;

class Main {
    // 깊이 우선 탐색
    private static void dfs_(int start, ArrayList<Integer>[] graph, boolean[] visited, StringBuilder sb) {
        for(int end: graph[start])
            if(!visited[end]) {
                visited[end] = true;
                sb.append(end).append(' ');
                dfs_(end, graph, visited, sb);
            }
    }
    private static void dfs(int start, ArrayList<Integer>[] graph, StringBuilder sb) {
        boolean[] visited = new boolean[graph.length];
        visited[start] = true;
        sb.append(start).append(' ');
        dfs_(start, graph, visited, sb);
        sb.append('\n');
    }

    // 너비 우선 탐색
    private static void bfs(int start, ArrayList<Integer>[] graph, StringBuilder sb) {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];
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
        ArrayList<Integer>[] graph;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

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

        dfs(v, graph, sb);
        bfs(v, graph, sb);

        System.out.print(sb);
        br.close();
    }
}