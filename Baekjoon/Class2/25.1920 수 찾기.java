import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n, m;
        long[] nArr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nArr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            nArr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(nArr); // 정렬

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            long mNum = Long.parseLong(st.nextToken());
            // 이진 탐색 O(logn)
            if(Arrays.binarySearch(nArr, mNum) > -1)
                sb.append("1\n");
            else
                sb.append("0\n");
        }

        System.out.print(sb);
        br.close();
    }
}

/* 이진 탐색 구현
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static int binSearch(long[] arr, int num) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int middle = (left + right) / 2;
            switch(Integer.compare(left, right)) {
                case 0: return middle;
                case -1: left = middle + 1;
                    break;
                case 1: right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        int n, m;
        long[] nArr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nArr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            nArr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(nArr); // 정렬

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            long mNum = Long.parseLong(st.nextToken());
            // 이진 탐색 O(logn)
            if(Arrays.binarySearch(nArr, mNum) > -1)
                sb.append("1\n");
            else
                sb.append("0\n");
        }

        System.out.print(sb);
        br.close();
    }
}
*/

/* HashSet 사용
import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n, m;
        HashSet<Long> nSet = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            nSet.add(Long.parseLong(st.nextToken()));

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            long mNum = Long.parseLong(st.nextToken());
            // HashSet 해시 테이블을 사용하므로 contains()에 대해 O(1)
            if(nSet.contains(mNum))
                sb.append("1\n");
            else
                sb.append("0\n");
        }

        System.out.print(sb);
        br.close();
    }
}
*/