import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int testCase;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());

            HashMap<String, Integer> clothes = new HashMap<>(); // 옷의 종류
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }

            int cases = 1; // 옷을 입는 경우의 수
            for(int val: clothes.values())
                cases *= val + 1;
            sb.append(cases - 1).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}