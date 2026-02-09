import java.io.*;
import java.util.Comparator;
import java.util.ArrayList;

class Main {
    private static final Comparator<String> dictSort = (s1, s2) -> {
        if(s1.length() != s2.length()) // 길이순 정렬
            return s1.length() - s2.length();
        return s1.compareTo(s2); // 문자순 정렬
    };

    public static void main(String[] args) throws IOException {
        int n;
        ArrayList<String> words = new ArrayList<>();
        String prevWord = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++)
            words.add(br.readLine());
        words.sort(dictSort); // 정렬
        for(String word: words) {
            if(prevWord.equals(word)) continue; // 중복 건너뛰기
            sb.append(word).append('\n');
            prevWord = word;
        }
        System.out.print(sb);
        br.close();
    }
}