import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static boolean[] knows;
    private static int[] parents;

    private static int collapsingFind(int node) {
        if(parents[node] == node) // 루트 반환
            return node;
        return parents[node] = collapsingFind(parents[node]); // 자손 노드들을 루트 노드에 달기
    }

    private static void unionRoot(int node1, int node2) {
        node1 = collapsingFind(node1);
        node2 = collapsingFind(node2);

        if(node1 != node2) { // 두 루트가 다르다면
            if(knows[node1]) knows[node2] = true; // 지식 전파
            else if(knows[node2]) knows[node1] = true;
            parents[node1] = node2; // 유니언
        }
    }

    public static void main(String[] args) throws IOException {
        int n, m, knowing_count; // 사람 수, 파티 수, 아는 사람 수
        int possibleLieCount = 0;
        int[][] parties;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 사람 수
        m = Integer.parseInt(st.nextToken()); // 파티 수

        knows = new boolean[n + 1];
        parents = new int[n + 1];
        for(int i = 1; i <= n; i++) // 루트는 자기 자신을 부모로
            parents[i] = i;

        st = new StringTokenizer(br.readLine());
        knowing_count = Integer.parseInt(st.nextToken()); // 아는 사람 수
        for(int i = 0; i < knowing_count; i++) { // 아는 사람 설정
            int knowingPerson = Integer.parseInt(st.nextToken());
            knows[knowingPerson] = true;
        }

        parties = new int[m][];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int visitorCount = Integer.parseInt(st.nextToken());
            parties[i] = new int[visitorCount];
            for(int j = 0; j < visitorCount; j++) // 파티 참석자 정보
                parties[i][j] = Integer.parseInt(st.nextToken());
            for(int j = 0; j < visitorCount - 1; j++) // 파티 참석자 유니언 및 지식 전파
                unionRoot(parties[i][j], parties[i][j + 1]);
        }

        for(int[] party : parties) {
            boolean canLie = true;
            for(int visitor : party) // 파티마다
                if(knows[collapsingFind(visitor)]) { // 아는 사람이 있으면 거짓말을 못 함
                    canLie = false;
                    break;
                }
            if(canLie) possibleLieCount++;
        }

        System.out.print(possibleLieCount);
        br.close();
    }
}