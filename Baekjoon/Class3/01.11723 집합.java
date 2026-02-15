import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static class BitmaskSet { // long 비트마스크 세트
        private long set;
        public BitmaskSet() { set = 0; }
        public void add(int data) {
            set |= 1L << (data - 1);
        }
        public void remove(int data) {
            set &= ~(1L << (data - 1));
        }
        public boolean check(int data) {
            return (set & (1L << (data - 1))) != 0;
        }
        public void toggle(int data) {
            set ^= 1L << (data - 1);
        }
        public void all() {
            set = ~0L;
        }
        public void empty() {
            set = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        int m;
        BitmaskSet s = new BitmaskSet();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            int num;
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    s.add(num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    s.remove(num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append(s.check(num) ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    s.toggle(num);
                    break;
                case "all":
                    s.all();
                    break;
                case "empty":
                    s.empty();
                    break;
            }
        }
        System.out.print(sb);
        br.close();
    }
}

/* 라이브러리 사용
import java.io.*;
import java.util.BitSet;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int m;
        BitSet s = new BitSet(21);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            int num;
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    s.set(num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    s.clear(num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append(s.get(num) ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    s.flip(num);
                    break;
                case "all":
                    s.set(1, 21);
                    break;
                case "empty":
                    s.clear();
                    break;
            }
        }
        System.out.print(sb);
        br.close();
    }
}
*/