// 너비 우선 탐색
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int pcN, linkN;
        ArrayList<Integer>[] graph;
        boolean[] visited;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        pcN = Integer.parseInt(br.readLine());
        linkN = Integer.parseInt(br.readLine());

        graph = new ArrayList[pcN + 1]; // 무방향성 그래프
        for(int i = 1; i <= pcN; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < linkN; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        Deque<Integer> bfs = new ArrayDeque<>();
        visited = new boolean[pcN + 1];
        bfs.addLast(1); // 1번 감염
        visited[1] = true;
        int infectedCount = 1;
        while(!bfs.isEmpty()) {
            int start = bfs.removeFirst();
            for(int end: graph[start])
                if(!visited[end]) {
                    bfs.addLast(end);
                    visited[end] = true;
                    infectedCount++;
                }
        }
        System.out.print(infectedCount - 1);
        br.close();
    }
}

/* 깊이 우선 탐색
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    private static void dfs(int start) {
        visited[start] = true;
        for(int end: graph[start])
            if(!visited[end])
                dfs(end);
    }

    public static void main(String[] args) throws IOException {
        int pcN, linkN;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        pcN = Integer.parseInt(br.readLine());
        linkN = Integer.parseInt(br.readLine());

        graph = new ArrayList[pcN + 1]; // 무방향성 그래프
        for(int i = 1; i <= pcN; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < linkN; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        visited = new boolean[pcN + 1];
        dfs(1); // 1번 감염

        int infectedCount = 0;
        for(int i = 2; i <= pcN; i++)
            if(visited[i]) infectedCount++;
        System.out.print(infectedCount);
        br.close();
    }
}
*/