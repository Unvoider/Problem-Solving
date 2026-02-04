import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

class Main {
    public static void main(String[] args) throws IOException {
        int n, m, closest = 0;
        Vector<Integer> nums = new Vector<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            nums.add(Integer.parseInt(st.nextToken()));

        for(int i = 0; i < n - 2; i++)
            for(int j = i + 1; j < n - 1; j++)
                for(int k = j + 1; k < n; k++) {
                    int total = nums.get(i) + nums.get(j) + nums.get(k);
                    if(total <= m && total > closest) {
                        closest = total;
                        if(closest == m) // 같으면 바로 종료
                            i = j = k = n;
                    }
                }
        System.out.print(closest);
        br.close();
    }
}