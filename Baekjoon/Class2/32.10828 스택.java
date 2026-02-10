import java.io.*;
import java.util.EmptyStackException;
import java.util.StringTokenizer;

class Main {
    private static class Stack<T> { // 연결 리스트 스택
        private static class Node<T> {  // 연결 리스트 노드
            T data;
            Node<T> next;
            public Node(T data, Node<T> next) {
                this.data = data;
                this.next = next;
            }
        }
        private Node<T> top; // 첫 노드
        private int size;

        public Stack() {
            top = null;
            size = 0;
        }
        public void push(T item) {
            size++;
            Node<T> nodeToPush = new Node<T>(item, top);
            top = nodeToPush;
        }
        public T pop() {
            if (empty()) throw new EmptyStackException();
            size--;
            T item = top.data;
            top = top.next;
            return item;
        }
        public int size() {
            return size;
        }
        public boolean empty() {
            return size == 0;
        }
        public T top() {
            if (empty()) throw new EmptyStackException();
            return top.data;
        }
    }

    public static void main(String[] args) throws IOException {
        int n;
        Stack<Integer> nums = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String command;
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            try {
                switch (command) {
                    case "push":
                        nums.push(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop":
                        sb.append(nums.pop()).append('\n');
                        break;
                    case "size":
                        sb.append(nums.size()).append('\n');
                        break;
                    case "empty":
                        sb.append(nums.empty() ? 1 : 0).append('\n');
                        break;
                    case "top":
                        sb.append(nums.top()).append('\n');
                        break;
                }
            }
            catch (EmptyStackException e) { // 스택 빔
                sb.append("-1\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}

/* 라이브러리 사용
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        Deque<Integer> nums = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String command;
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            switch (command) {
                case "push":
                    nums.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(nums.isEmpty()) {
                        sb.append("-1\n");
                        continue;
                    }
                    sb.append(nums.pop()).append('\n');
                    break;
                case "size":
                    sb.append(nums.size()).append('\n');
                    break;
                case "empty":
                    sb.append(nums.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "top":
                    if(nums.isEmpty()) {
                        sb.append("-1\n");
                        continue;
                    }
                    sb.append(nums.peek()).append('\n');
                    break;
            }
        }
        System.out.print(sb);
        br.close();
    }
}
*/