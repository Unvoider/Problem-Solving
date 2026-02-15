import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    private static class Pokedex {
        private int size;
        private String[] indexToName;
        private HashMap<String, Integer> nameToIndex;

        public Pokedex(int reserveSize) {
            size = 0;
            indexToName = new String[reserveSize + 1];
            indexToName[0] = "Dummy"; // 0번 인덱스 더미 데이터
            nameToIndex = new HashMap<>(reserveSize);
        }
        public void add(String name) {
            size++;
            indexToName[size] = name;
            nameToIndex.put(name, size);
        }
        public String getName(int index) {
            return indexToName[index];
        }
        public int getIndex(String name) {
            return nameToIndex.get(name);
        }
    }

    public static void main(String[] args) throws IOException {
        int n, m;
        Pokedex pokedex;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pokedex = new Pokedex(n);

        for(int i = 0; i < n; i++) { // 이름 등록
            String name = br.readLine();
            pokedex.add(name);
        }

        for(int i = 0; i < m; i++) { // 검색
            String target = br.readLine();
            if(Character.isDigit(target.charAt(0))) { // 인덱스 검색
                int index = Integer.parseInt(target);
                sb.append(pokedex.getName(index)).append('\n');
            }
            else // 이름 검색
                sb.append(pokedex.getIndex(target)).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}