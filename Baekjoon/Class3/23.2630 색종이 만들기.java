import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final char WHITE = '0';
    private static final char BLUE = '1';

    private static class PaperCount {
        int white;
        int blue;
        public PaperCount(int white, int blue) {
            this.white = white;
            this.blue = blue;
        }
    }

    private static char[][] paper;

    private static boolean isUniform(int r, int c, int size) {
        char first = paper[r][c];
        for(int i = r; i < r + size; i++)
            for(int j = c; j < c + size; j++)
                if(first != paper[i][j])
                    return false;
        return true;
    }

    private static PaperCount cutPapers(int r, int c, int size) {
        if(isUniform(r, c, size)) // 모두 같은 색일 때 종료
            return new PaperCount(
                    paper[r][c] == WHITE ? 1 : 0,
                    paper[r][c] == BLUE ? 1 : 0
            );

        int half = size / 2; // 사등분
        int white = 0, blue = 0;
        for(int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                PaperCount paper_count = cutPapers(r + i * half, c + j * half, half);
                white += paper_count.white;
                blue += paper_count.blue;
            }
        return new PaperCount(white, blue);
    }

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        paper = new char[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                paper[i][j] = st.nextToken().charAt(0);
        }

        PaperCount paperCount = cutPapers(0, 0, n);
        sb.append(paperCount.white).append('\n')
                .append(paperCount.blue).append('\n');
        System.out.print(sb);
        br.close();
    }
}