import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

class Main {
    private static void ac(BufferedReader br, StringBuilder sb) throws IOException {
        char[] p = br.readLine().toCharArray();
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");

        Deque<Integer> xn = new ArrayDeque<>();
        while(st.hasMoreTokens()) // 파싱
            xn.addLast(Integer.parseInt(st.nextToken()));

        boolean isFront = true; // 포인터 위치
        for(char command: p)
            if (command == 'R') // 덱 뒤집기
                isFront = !isFront;
            else { // 팝
                if (xn.isEmpty()) { // 비었음
                    sb.append("error\n");
                    return;
                }
                if (isFront)
                    xn.removeFirst();
                else
                    xn.removeLast();
            }

        sb.append('['); // 출력
        if(!xn.isEmpty()) {
            Iterator<Integer> it = isFront ? xn.iterator() : xn.descendingIterator();
            sb.append(it.next());
            while(it.hasNext())
                sb.append(',').append(it.next());
        }
        sb.append("]\n");
    }

    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++)
            ac(br, sb);
        System.out.print(sb);
        br.close();
    }
}