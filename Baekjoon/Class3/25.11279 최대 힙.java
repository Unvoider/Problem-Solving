import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

class Main {
    private static class MaxHeap<T extends Comparable<T>> {
        private ArrayList<T> heap;

        public MaxHeap() {
            heap = new ArrayList<>();
            heap.add(null); // root 인덱스 1
        }
        public boolean empty() {
            return heap.size() == 1;
        }
        public void push(T data) {
            int inPos = heap.size(); // 마지막 인덱스를 삽입 위치로
            int parent = inPos >> 1;
            heap.add(null);
            // 삽입 위치가 root가 아니고 자식 값이 부모 값보다 큰 동안
            while(inPos != 1 && data.compareTo(heap.get(parent)) > 0) {
                heap.set(inPos, heap.get(parent)); // 부모를 자식으로
                inPos >>= 1; // 자식을 부모로
                parent = inPos >> 1;
            }
            heap.set(inPos, data);
        }
        public T pop() {
            if(empty()) throw new NoSuchElementException();
            T data = heap.get(1);
            T last = heap.remove(heap.size() - 1); // 마지막 값을 root 자리에 올림
            if(empty()) return data;
            int inPos = 1;
            int child = 2;
            int heapSize = heap.size();
            while(child < heapSize) { // 자식이 존재하는 동안
                if(child + 1 < heapSize && heap.get(child).compareTo(heap.get(child + 1)) < 0)
                    child++; // 왼쪽/오른쪽 자식 중 더 큰 값 고르기
                if(last.compareTo(heap.get(child)) >= 0) break; // 부모 값이 자식 값보다 작은 동안
                heap.set(inPos, heap.get(child)); // 자식을 부모로
                inPos = child; // 부모를 자식으로
                child = inPos << 1;
            }
            heap.set(inPos, last);
            return data;
        }
    }

    public static void main(String[] args) throws IOException {
        int n;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0)
                if(maxHeap.empty())
                    sb.append("0\n");
                else
                    sb.append(maxHeap.pop()).append('\n');
            else
                maxHeap.push(x);
        }
        System.out.print(sb);
        br.close();
    }
}

/* 라이브러리 사용
import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        int n;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0)
                if(maxHeap.isEmpty())
                    sb.append("0\n");
                else
                    sb.append(maxHeap.remove()).append('\n');
            else
                maxHeap.add(x);
        }
        System.out.print(sb);
        br.close();
    }
}
*/