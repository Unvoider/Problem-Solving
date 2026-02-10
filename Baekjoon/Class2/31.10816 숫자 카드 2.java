// HashMap 사용
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int n, m;
        HashMap<Integer, Integer> cards = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            cards.put(card, cards.getOrDefault(card, 0) + 1); // 개수 세기
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            // HashMap의 접근 시간 O(1)
            sb.append(cards.getOrDefault(target, 0)).append(' ');
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
    private static int binSearchLowerBound(int[] arr, int target) {
        int lowerBound = -1;
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int middle = (left + right) / 2;
            if(arr[middle] >= target) {
                if(arr[middle] == target) // 찾음
                    lowerBound = middle;
                right = middle - 1; // 찾았어도 왼쪽 범위 계속 확인
            }
            else
                left = middle + 1;
        }
        return lowerBound;
    }

    private static int binSearchUpperBound(int[] arr, int target) {
        int upperBound = -1;
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int middle = (left + right) / 2;
            if(arr[middle] <= target) {
                if(arr[middle] == target) // 찾음
                    upperBound = middle + 1;
                left = middle + 1; // 찾았어도 오른쪽 범위 계속 확인
            }
            else
                right = middle - 1;
        }
        return upperBound;
    }

    public static void main(String[] args) throws IOException {
        int n, m;
        int[] cards;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            cards[i] = card;
        }
        Arrays.sort(cards); // 정렬

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            // 시작과 끝 인덱스 이진 탐색 O(logn)
            int targetLB = binSearchLowerBound(cards, target);
            if(targetLB == -1) { // 시작 인덱스 없음
                sb.append("0 ");
                continue;
            }
            int targetUB = binSearchUpperBound(cards, target);
            sb.append(targetUB - targetLB).append(' ');
        }
        System.out.print(sb);
        br.close();
    }
}
*/