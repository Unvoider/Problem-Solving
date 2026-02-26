// 이진 탐색
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        int[] xn, sortedXn;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        xn = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            xn[i] = Integer.parseInt(st.nextToken());

        sortedXn = Arrays.stream(xn).distinct().sorted().toArray(); // 중복 제거, 정렬

        for(int x: xn) // 이진 탐색으로 위치 찾기
            sb.append(Arrays.binarySearch(sortedXn, x)).append(' ');
        System.out.print(sb);
        br.close();
    }
}

/* HashMap 사용
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        int[] xn, sortedXn;
        HashMap<Integer, Integer> compression;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        xn = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            xn[i] = Integer.parseInt(st.nextToken());

        sortedXn = Arrays.stream(xn).distinct().sorted().toArray(); // 중복 제거, 정렬

        compression = new HashMap<>(); // unordered_map으로 순서 저장
        for(int i = 0; i < sortedXn.length; i++)
            compression.put(sortedXn[i], i);

        for(int x: xn)
            sb.append(compression.get(x)).append(' ');
        System.out.print(sb);
        br.close();
    }
}
*/