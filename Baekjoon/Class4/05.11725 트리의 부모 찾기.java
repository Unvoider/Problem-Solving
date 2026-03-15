import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        ArrayList<Integer>[] graph;
        int[] parents;
        Deque<Integer> bfs = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1]; // 무방향성 그래프
        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        parents = new int[n + 1];
        bfs.push(1); // 루트에서부터 너비 우선 탐색
        parents[1] = -1;
        while(!bfs.isEmpty()) {
            int start = bfs.removeFirst();
            for(int end : graph[start])
                if(parents[end] == 0) { // 부모 설정
                    parents[end] = start;
                    bfs.addLast(end);
                }
        }

        for(int i = 2; i <= n; i++)
            sb.append(parents[i]).append('\n');
        System.out.print(sb);
        br.close();
    }
}