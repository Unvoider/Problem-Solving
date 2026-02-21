import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static long countCutWire(long length, long[] wires) { // 잘린 선 개수
        long count = 0;
        for(long wire: wires)
            count += wire / length;
        return count;
    }

    private static long maxCutLength(int required, long[] wires) {
        long answer = 0;
        long left = 1L, right = wires[0];
        for(int i = 1; i < wires.length; i++)
            right = Math.max(right, wires[i]);
        while(left <= right) {
            long middle = left + (right - left) / 2L;
            if(countCutWire(middle, wires) >= required) { // 더 길게 자를 수도 있음
                left = middle + 1L;
                answer = middle;
            }
            else // 더 짧게 잘라야 함
                right = middle - 1L;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        int k, n;
        long[] wires;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        wires = new long[k];
        for(int i = 0; i < k; i++)
            wires[i] = Integer.parseInt(br.readLine());

        System.out.print(maxCutLength(n, wires));
        br.close();
    }
}