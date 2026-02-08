import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    private static boolean balancedWorld(String str) {
        Deque<Character> brackets = new ArrayDeque<Character>();
        for(char ch: str.toCharArray())
            if(ch == '(' || ch == '[') // 왼쪽 괄호 push
                brackets.push(ch);
            else if(ch == ')' || ch == ']') { // 오른쪽 괄호 pop
                if(brackets.isEmpty()) return false; // 스택 빔
                char top = brackets.pop();
                if(top != '(' && ch == ')') // 괄호 짝 안 맞음
                    return false;
                if(top != '[' && ch == ']')
                    return false;
            }
        return brackets.isEmpty(); // 남은 괄호 없으면 성공
    }

    public static void main(String[] args) throws IOException {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(!(str = br.readLine()).equals("."))
            if(balancedWorld(str)) sb.append("yes\n");
            else sb.append("no\n");
        System.out.print(sb.toString());
        br.close();
    }
}