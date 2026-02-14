import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        int n, total = 0;
        int[] nums;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
            total += num; // 합계
        }

        Arrays.sort(nums); // 정렬

        // 두 번째로 작은 최빈값 찾기
        int prev = nums[0], mode = nums[0], freq = 1, maxFreq = 1, modeCount = 1;
        for(int i = 1; i < n; i++) {
            // 빈도 계산
            if(prev == nums[i])
                freq++;
            else
                freq = 1;

            // 최대 빈도 찾기
            if(freq == maxFreq) { // 최대 빈도와 같은 빈도
                if(modeCount < 2) { // 두 번째까지 업데이트
                    modeCount++;
                    mode = nums[i];
                }
            }
            else if(freq > maxFreq) { // 최대 빈도보다 높은 빈도
                modeCount = 1;
                maxFreq = freq;
                mode = nums[i];
            }

            prev = nums[i];
        }

        sb.append(Math.round(total / (double)n)).append('\n'); // 산술평균
        sb.append(nums[n / 2]).append('\n'); // 중앙값
        sb.append(mode).append('\n'); // 최빈값
        sb.append(nums[n - 1] - nums[0]).append('\n'); // 범위
        System.out.print(sb);
        br.close();
    }
}