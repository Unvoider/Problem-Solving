import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

class Main {
    private static class Queue<T> { // 연결 리스트 큐
        private static class Node<T> {  // 연결 리스트 노드
            T data;
            Node<T> next;
            public Node(T data, Node<T> next) {
                this.data = data;
                this.next = next;
            }
        }
        private Node<T> front; // 첫 노드
        private Node<T> back; // 마지막 노드
        private int size;

        public Queue() {
            front = back = null;
            size = 0;
        }
        public void push(T data) {
            size++;
            Node<T> nodeToPush = new Node<T>(data, null);
            if (size == 1)
                front = back = nodeToPush;
            else {
                back.next = nodeToPush;
                back = nodeToPush;
            }
        }
        public T pop() {
            if (empty()) throw new NoSuchElementException();
            size--;
            T data = front.data;
            front = front.next;
            if (front == null) back = null;
            return data;
        }
        public int size() {
            return size;
        }
        public boolean empty() {
            return size == 0;
        }
        public T front() {
            if (empty()) throw new NoSuchElementException();
            return front.data;
        }
        public T back() {
            if (empty()) throw new NoSuchElementException();
            return back.data;
        }
    }

    public static void main(String[] args) throws IOException {
        int n;
        Queue<Integer> nums = new Queue<>();
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
                    case "front":
                        sb.append(nums.front()).append('\n');
                        break;
                    case "back":
                        sb.append(nums.back()).append('\n');
                        break;
                }
            }
            catch (NoSuchElementException e) { // 큐 빔
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
                    nums.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(nums.isEmpty()) {
                        sb.append("-1\n");
                        continue;
                    }
                    sb.append(nums.removeFirst()).append('\n');
                    break;
                case "size":
                    sb.append(nums.size()).append('\n');
                    break;
                case "empty":
                    sb.append(nums.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    if(nums.isEmpty()) {
                        sb.append("-1\n");
                        continue;
                    }
                    sb.append(nums.peekFirst()).append('\n');
                    break;
                case "back":
                    if(nums.isEmpty()) {
                        sb.append("-1\n");
                        continue;
                    }
                    sb.append(nums.peekLast()).append('\n');
                    break;
            }
        }
        System.out.print(sb);
        br.close();
    }
}
*/