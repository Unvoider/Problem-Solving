import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        int[] sides = new int[3];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 3; i++)
                sides[i] = Integer.parseInt(st.nextToken());
            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0)
                break;
            Arrays.sort(sides);
            if (sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2])
                sb.append("right\n");
            else
                sb.append("wrong\n");
        }
        System.out.print(sb);
        br.close();
    }
}
/*
class Main {
    public static void main(String[] args) throws IOException {
        int a, b, c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0)
                break;
            if (a * a + b * b == c * c
                || b * b + c * c == a * a
                || c * c + a * a == b * b)
                sb.append("right\n");
            else
                sb.append("wrong\n");
        }
        System.out.print(sb);
        br.close();
    }
}
*/