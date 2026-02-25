import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    private static int countComponents(ArrayList<Integer>[] graph) {
        int count = 0;
        Deque<Integer> bfs = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];
        for(int i = 1; i < graph.length; i++) {
            if(visited[i]) continue;
            bfs.addLast(i); // 컴포넌트 발견
            visited[i] = true;
            count++;
            while(!bfs.isEmpty()) {
                int start = bfs.removeFirst();
                for(int end: graph[start]) {
                    if(!visited[end]){
                        bfs.addLast(end);
                        visited[end] = true;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        int n, m;
        ArrayList<Integer>[] graph;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        for(int i = 1; i < graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) { // 무방향성 그래프
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        System.out.print(countComponents(graph));
        br.close();
    }
}