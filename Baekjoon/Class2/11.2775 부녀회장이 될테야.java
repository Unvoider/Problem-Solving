// 반복 동적 프로그래밍
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int t, k, n;
        int[][] apt = new int[15][15]; // 타뷸레이션
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 15; i++) {
            apt[0][i] = i + 1; // 0층 초기화
            apt[i][0] = 1; // 1호 초기화
        }
        for(int i = 1; i < 15; i++) // 전체 계산
            for(int j = 1; j < 15; j++)
                apt[i][j] = apt[i - 1][j] + apt[i][j - 1]; // 아랫집 + 왼쪽 집

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            sb.append(apt[k][n - 1]).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}

/* 재귀 동적 프로그래밍
import java.io.*;

class Main {
    private static final int[][] apt = new int[15][15]; // 메모이제이션

    private static int countPeople(int floor, int room) {
        // 0층/1호 고정 값
        if(floor == 0) return room;
        if(room == 1) return 1;

        // 저장된 값 반환
        int count = apt[floor][room];
        if(count != 0) return count;

        // 없으면 계산
        count = countPeople(floor - 1, room) + countPeople(floor, room - 1);
        apt[floor][room] = count;
        return count;
    }

    public static void main(String[] args) throws IOException {
        int t, k, n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 15; i++) {
            apt[0][i] = i + 1; // 0층 초기화
            apt[i][0] = 1; // 1호 초기화
        }

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            sb.append(countPeople(k, n)).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
*/