import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n, m;
        HashMap<String, String> passwords;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        passwords = new HashMap<>(n); // <site, password>
        for(int i = 0; i < n; i++) { // 비밀번호 입력
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            passwords.put(site, password);
        }
        for(int i = 0; i < m; i++) { // 비밀번호 출력
            String site = br.readLine();
            sb.append(passwords.get(site)).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}