import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    private static final int MAX_DIST = 1000000000;

    private static class Point {
        int r, c;
        public Point(int r, int c) { this.r = r; this.c = c; }
    }

    private static int n, m; // 행렬 크기, 폐업시키지 않을 치킨 집 수
    private static ArrayList<Point> houses = new ArrayList<>();
    private static ArrayList<Point> chickens = new ArrayList<>();
    private static boolean[] isOpen;
    private static int[][] chickenDists;
    private static int chickenDist = MAX_DIST;

    private static void chooseChickens(int cur, int count) {
        if(count == m) { // m개 선택됨
            int totalMinDist = 0;
            for(int i = 0; i < houses.size(); i++) { // 각 집과 열린 치킨집의 최소 거리 누적
                int minDist = MAX_DIST;
                for(int j = 0; j < chickens.size(); j++)
                    if(isOpen[j])
                        minDist = Math.min(minDist, chickenDists[i][j]);
                totalMinDist += minDist;
            }
            chickenDist = Math.min(chickenDist, totalMinDist); // 최소 거리 업데이트
            return;
        }

        for(int i = cur; i < chickens.size(); i++) { // 모든 조합 확인
            isOpen[i] = true;
            chooseChickens(i + 1, count + 1);
            isOpen[i] = false; // 백트래킹
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < n; c++) { // 집과 치킨집의 위치 저장
                int house = Integer.parseInt(st.nextToken());
                if(house == 1)
                    houses.add(new Point(r, c));
                else if(house == 2)
                    chickens.add(new Point(r, c));
            }
        }

        // 타뷸레이션
        chickenDists = new int[houses.size()][chickens.size()];
        for(int i = 0; i < houses.size(); i++) // 각 집과 치킨집의 최소 거리 구하기
            for(int j = 0; j < chickens.size(); j++)
                chickenDists[i][j] = Math.abs(chickens.get(j).r - houses.get(i).r) + Math.abs(chickens.get(j).c - houses.get(i).c);

        isOpen = new boolean[chickens.size()];

        chooseChickens(0, 0);
        System.out.print(chickenDist);
        br.close();
    }
}