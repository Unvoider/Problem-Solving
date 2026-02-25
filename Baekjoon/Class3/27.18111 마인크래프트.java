import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final int HEIGHT_LIMIT = 256;

    public static void main(String[] args) throws IOException {
        int n, m, b;
        int minH = HEIGHT_LIMIT, maxH = 0;
        int[] heightCounts = new int[HEIGHT_LIMIT + 1];
        int minTime = Integer.MAX_VALUE, flatH = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int h = Integer.parseInt(st.nextToken());
                if (minH > h) minH = h;
                if (maxH < h) maxH = h;
                heightCounts[h]++;
            }
        }

        for(int targetH = minH; targetH <= maxH; targetH++) { // 모든 높이 확인
            int toPlace = 0, toBreak = 0; // 해당 높이에서 설치/삭제해야 하는 블록 수
            for(int curH = minH; curH <= maxH; curH++) {
                int blocks = targetH - curH;
                if(blocks > 0)
                    toPlace += blocks * heightCounts[curH];
                else if(blocks < 0)
                    toBreak -= blocks * heightCounts[curH];
            }
            if(b + toBreak >= toPlace) { // 인벤토리 블록 수 확인
                int time = toBreak * 2 + toPlace;
                if(minTime >= time) { // 최소 시간 갱신
                    minTime = time;
                    flatH = targetH;
                }
            }
        }

        System.out.print(
                sb.append(minTime).append(' ').append(flatH)
        );
        br.close();
    }
}