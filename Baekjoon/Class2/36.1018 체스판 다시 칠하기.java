import java.io.*;
import java.util.StringTokenizer;

class Main {
    // 나머지 연산
    private static int countPaint(char[][] board, int row, int col) { // 색칠해야 하는 칸 세기
        int count = 0;
        for(int i = row; i < row + 8; i++)
            for(int j = col; j < col + 8; j++)
                if((i + j) % 2 == 0 && board[i][j] == 'B') // 잘못 색칠된 검정
                    count++;
                else if((i + j) % 2 == 1 && board[i][j] == 'W') // 잘못 색칠된 하양
                    count++;
        return count;
    }

    /* 체스판 생성
    private static int countPaint(char[][] board, int row, int col) { // 색칠해야 하는 칸 세기
        char rowFirst = 'W'; // 흰색으로 시작하는 체스 보드
        int count = 0;
        for(int i = 0; i < 8; i++) {
            char cur = rowFirst;
            for(int j = 0; j < 8; j++) {
                if(board[i + row][j + col] != cur)
                    count++;
                cur = (cur == 'W') ? 'B' : 'W';
            }
            rowFirst = (rowFirst == 'W') ? 'B' : 'W';
        }
        return count;
    }
     */

    /* 체스판 정의
    private static final char[][] CHESS_BOARD = { // 흰색으로 시작하는 체스 보드
            "WBWBWBWB".toCharArray(),
            "BWBWBWBW".toCharArray(),
            "WBWBWBWB".toCharArray(),
            "BWBWBWBW".toCharArray(),
            "WBWBWBWB".toCharArray(),
            "BWBWBWBW".toCharArray(),
            "WBWBWBWB".toCharArray(),
            "BWBWBWBW".toCharArray()
    };
    private static int countPaint(char[][] board, int row, int col) { // 색칠해야 하는 칸 세기
        int count = 0;
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (board[i + row][j + col] != CHESS_BOARD[i][j])
                    count++;
        return count;
    }
    */

    public static void main(String[] args) throws IOException {
        int n, m, minCount = 64;
        char[][] board;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        for(int i = 0; i < n; i++)
            board[i] = br.readLine().toCharArray();

        for(int row = 0; row <= n - 8; row++)
            for(int col = 0; col <= m - 8; col++) {
                int count = countPaint(board, row, col);
                // 흰색으로 시작할 때 색칠할 칸, 반전한 경우, 이전 최소값 중 최소값 선택
                minCount = Math.min(Math.min(count, 64 - count), minCount);
            }
        System.out.print(minCount);
        br.close();
    }
}