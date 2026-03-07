import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static class Meeting {
        int start, end;
        public Meeting(int start, int end) { this.start = start; this.end = end; }
    }

    public static void main(String[] args) throws IOException {
        int n;
        Meeting[] meetings;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        meetings = new Meeting[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meetings, (m1, m2) -> {
            if(m1.end != m2.end) return m1.end - m2.end;
            return m1.start - m2.start;
        }); // 끝나는 시간 기준 정렬

        int maxCount = 1; // 첫 미팅
        int prevEnd = meetings[0].end;
        for(int i = 1; i < n; i++)
            if(prevEnd <= meetings[i].start) { // 다음 미팅 추가
                maxCount++;
                prevEnd = meetings[i].end;
            }

        System.out.print(maxCount);
        br.close();
    }
}