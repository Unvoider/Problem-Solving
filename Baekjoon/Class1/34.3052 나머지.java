import java.io.*;

class Main {
    private static final int INPUT_COUNT = 10, DIVISOR = 42;
    public static void main(String[] args) throws IOException {
        int diffCount = 0;
        boolean[] hasNums = new boolean[DIVISOR];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < INPUT_COUNT; i++) {
            int num = Integer.parseInt(br.readLine()) % DIVISOR;
            hasNums[num] = true;
        }
        for(int i = 0; i < DIVISOR; i++)
            if(hasNums[i]) diffCount++;

        System.out.print(diffCount);
        br.close();
    }
}

/* HashSet 사용
import java.io.*;
import java.util.HashSet;

class Main {
    private static final int INPUT_COUNT = 10, DIVISOR = 42;
    public static void main(String[] args) throws IOException {
        HashSet<Integer> numSet = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < INPUT_COUNT; i++)
            numSet.add(Integer.parseInt(br.readLine()) % DIVISOR);

        System.out.print(numSet.size());
        br.close();
    }
}
*/