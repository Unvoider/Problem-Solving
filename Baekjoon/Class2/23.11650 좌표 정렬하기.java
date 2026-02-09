import java.io.*;
import java.util.*;

class Main {
    private static class Coordinate implements Comparable<Coordinate>{
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate c) {
            if(this.x != c.x) return this.x - c.x;
            else return this.y - c.y;
        }
    }

    public static void main(String[] args) throws IOException {
        int n;
        Coordinate[] coords;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        coords = new Coordinate[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coords[i]= new Coordinate(x, y);
        }

        Arrays.sort(coords);
        for(Coordinate coord: coords)
            sb.append(coord.x).append(' ').append(coord.y).append('\n');
        System.out.print(sb);
        br.close();
    }
}

/* Comparator 사용
import java.io.*;
import java.util.*;

class Main {
    private static class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        int n;
        Coordinate[] coords;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        coords = new Coordinate[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coords[i]= new Coordinate(x, y);
        }

        Arrays.sort(coords, (c1, c2) -> {
            if(c1.x != c2.x) return c1.x - c2.x;
            else return c1.y - c2.y;
        });
        for(Coordinate coord: coords)
            sb.append(coord.x).append(' ').append(coord.y).append('\n');
        System.out.print(sb);
        br.close();
    }
}
*/