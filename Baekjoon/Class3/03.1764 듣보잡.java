import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n, m;
        HashSet<String> unheard;
        ArrayList<String> unheardUnseen;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        unheard = new HashSet<>(n); // 듣도 못한 사람
        for(int i = 0; i < n; i++) {
            String name = br.readLine();
            unheard.add(name);
        }

        unheardUnseen = new ArrayList<>(); // 듣도 보도 못한 사람
        for(int i = 0; i < m; i++) {
            String name = br.readLine();
            if(unheard.contains(name))
                unheardUnseen.add(name);
        }

        Collections.sort(unheardUnseen); // 사전순 정렬
        sb.append(unheardUnseen.size()).append('\n');
        for(String name: unheardUnseen)
            sb.append(name).append('\n');
        System.out.print(sb);
        br.close();
    }
}