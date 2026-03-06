// 너비 우선 탐색
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        ArrayList<Integer>[] graph;
        byte[][] visited;
        Deque<Integer> bfs = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n]; // 인접 리스트
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                if(st.nextToken().equals("1"))
                    graph[i].add(j);
        }

        visited = new byte[n][n];
        for(int node = 0; node < n; node++) { // 매 노드마다 모든 경로 찾기
            bfs.addLast(node);
            while(!bfs.isEmpty()) {
                int start = bfs.removeFirst();
                for(int end: graph[start])
                    if(visited[node][end] == 0) {
                        visited[node][end] = 1;
                        bfs.addLast(end);
                    }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                sb.append(visited[i][j]).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}

/* 플로이드-워셜
import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        byte[][] graph;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new byte[n][n]; // 인접 행렬
        for(int i = 0; i < n; i++) { // 직접 경로
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                graph[i][j] = Byte.parseByte(st.nextToken());
        }

        for(int k = 0; k < n; k++) // 간접 경로
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    if(graph[i][k] + graph[k][j] == 2)
                        graph[i][j] = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                sb.append(graph[i][j]).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
*/