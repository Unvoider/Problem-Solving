import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int stepsN;
        int[] steps, maxScores;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        stepsN = Integer.parseInt(br.readLine());

        steps = new int[stepsN + 1];
        for(int i = 1; i <= stepsN; i++)
            steps[i] = Integer.parseInt(br.readLine());

        maxScores = new int[stepsN + 1]; // 타뷸레이션
        if(stepsN >= 1) maxScores[1] = steps[1];
        if(stepsN >= 2) maxScores[2] = steps[1] + steps[2];
        for(int i = 3; i <= stepsN; i++) {
            int leapBefore = steps[i] + maxScores[i - 2];
            int noLeapBefore = steps[i] + steps[i - 1] + maxScores[i - 3];
            maxScores[i] = Math.max(leapBefore, noLeapBefore);
        }
        System.out.print(maxScores[stepsN]);
        br.close();
    }
}