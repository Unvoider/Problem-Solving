// 너비 우선 탐색
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n, m, minKevin, minKevinIdx;
        ArrayList<Integer>[] graph;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1]; // 무방향성 그래프
        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start, end;
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        minKevin = Integer.MAX_VALUE;
        minKevinIdx = 0;
        for(int i = 1; i <= n; i++) {
            int kevin = 0;
            Deque<Integer> bfs = new ArrayDeque<>(); // 너비 우선 탐색
            int[] depths = new int[n + 1];
            Arrays.fill(depths, -1);
            bfs.addLast(i);
            depths[i] = 0;
            while(!bfs.isEmpty()) {
                int start = bfs.removeFirst();
                for(int end : graph[start]) {
                    if(depths[end] == -1) {
                        bfs.addLast(end);
                        depths[end] = depths[start] + 1;
                        kevin += depths[end]; // 케빈 베이컨 수 누적
                    }
                }
            }
            if(minKevin > kevin) {
                minKevin = kevin;
                minKevinIdx = i;
            }
        }

        System.out.print(minKevinIdx);
        br.close();
    }
}

/* 플로이드-워셜
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static final int MAX_USERS = 100;

    public static void main(String[] args) throws IOException {
        int n, m, minKevin, minKevinIdx;
        int[][] graph;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1]; // 격자 그래프
        for(int i = 1; i <= n; i++)
            Arrays.fill(graph[i], MAX_USERS);
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start, end;
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        for(int k = 1; k <= n; k++) // 모든 쌍 최단 경로
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++)
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]); // 지름길 찾기

        for(int i = 1; i <= n; i++) // 자기 자신에 대한 경로 0
            graph[i][i] = 0;

        minKevin = Integer.MAX_VALUE;
        minKevinIdx = 0;
        for(int i = 1; i <= n; i++) {
            int kevin = 0; // 케빈 베이컨 수 누적
            for (int j = 1; j <= n; j++)
                kevin += graph[i][j];
            if(minKevin > kevin) {
                minKevin = kevin;
                minKevinIdx = i;
            }
        }
        System.out.print(minKevinIdx);
        br.close();
    }
}
*/