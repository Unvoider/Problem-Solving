import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static boolean isLengthEnough(int cutterHeight, int required, int[] trees) {
        long length = 0;
        for(int tree: trees)
            if(tree > cutterHeight) {
                length += tree - cutterHeight;
                if (length >= required) return true; // 충분한 길이
            }
        return false; // 충분하지 않음
    }

    private static int maxCutterHeight(int required, int[] trees) {
        int answer = 0;
        int left = 0, right = trees[0];
        for(int i = 1; i < trees.length; i++)
            right = Math.max(right, trees[i]);
        while(left <= right) {
            int middle = left + ((right - left) / 2);
            if(isLengthEnough(middle, required, trees)) { // 더 높게 자를 수도 있음
                left = middle + 1;
                answer = middle;
            }
            else // 더 낮게 잘라야 함
                right = middle - 1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        int n, m;
        int[] trees;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            trees[i] = Integer.parseInt(st.nextToken());

        System.out.print(maxCutterHeight(m, trees));
        br.close();
    }
}