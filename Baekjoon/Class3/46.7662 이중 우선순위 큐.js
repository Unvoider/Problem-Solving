const fs = require("fs")

class StringTokenizer { // 토큰 생성기
    #input;
    #cursor;
    constructor() {
        const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
        this.#input = fs.readFileSync(inputFile, "utf8");
        this.#cursor = 0;
    }
    nextToken() {
        while(this.#input.charCodeAt(this.#cursor) <= 32)
            this.#cursor++;
        const start = this.#cursor;
        while(this.#input.charCodeAt(this.#cursor) > 32)
            this.#cursor++;
        return this.#input.slice(start, this.#cursor);
    }
}

class Heap { // 최소 힙
    #cmp;
    #heap;
    constructor(cmp) {
        this.#cmp = cmp;
        this.#heap = [null]; // root 인덱스 1
    }
    get empty() {
        return this.#heap.length === 1;
    }
    get top() {
        return this.#heap[1];
    }
    push(data) {
        let inPos = this.#heap.length; // 마지막 인덱스를 삽입 위치로
        let parent = inPos >> 1;
        this.#heap.push(null); // 끝 자리 만들기
        // 삽입 위치가 root가 아니고 자식 값이 부모 값보다 작은 동안
        while(inPos !== 1 && this.#cmp(data, this.#heap[parent]) < 0) {
            this.#heap[inPos] = this.#heap[parent]; // 부모를 자식으로
            inPos >>= 1; // 자식을 부모로
            parent = inPos >> 1;
        }
        this.#heap[inPos] = data;
    }
    pop() {
        if(this.empty) return undefined;
        const data = this.#heap[1];
        const last = this.#heap.pop(); // 마지막 값을 root 자리에 올림
        if(this.empty) return data;
        let inPos = 1;
        let child = 2;
        const heapLength = this.#heap.length;
        while(child < heapLength){ // 자식이 존재하는 동안
            if(child + 1 < heapLength && this.#cmp(this.#heap[child], this.#heap[child + 1]) > 0)
                child += 1; // 왼쪽/오른쪽 자식 중 더 작은 값 고르기
            if(this.#cmp(last, this.#heap[child]) <= 0) break; // 부모 값이 자식 값보다 큰 동안
            this.#heap[inPos] = this.#heap[child]; // 자식을 부모로
            inPos = child; // 부모를 자식으로
            child = inPos << 1;
        }
        this.#heap[inPos] = last;
        return data;
    }
}

let cursor = 1;
const runDualPriorityQueue = (st, out) => {
    const k = Number(st.nextToken());

    // [num, index]
    const minHeap = new Heap((a, b) => a[0] - b[0]);
    const maxHeap = new Heap((a, b) => b[0] - a[0]);
    const visited = new Array(k).fill(false);

    for(let i = 0; i < k; i++) {
        const operation = st.nextToken();
        const num = Number(st.nextToken());

        switch(operation) {
            case "I": // 삽입
                minHeap.push([num, i]);
                maxHeap.push([num, i]);
                break;
            case "D":
                if(num === -1) { // 최솟값 삭제
                    while(!minHeap.empty) {
                        if(visited[minHeap.top[1]]) { // 방문했던 노드 삭제
                            minHeap.pop();
                            continue;
                        }
                        visited[minHeap.top[1]] = true;
                        minHeap.pop();
                        break;
                    }
                }
                else { // 최댓값 삭제
                    while(!maxHeap.empty) {
                        if(visited[maxHeap.top[1]]) { // 방문했던 노드 삭제
                            maxHeap.pop();
                            continue;
                        }
                        visited[maxHeap.top[1]] = true;
                        maxHeap.pop();
                        break;
                    }
                }
        }
    }
    while(!minHeap.empty && visited[minHeap.top[1]]) minHeap.pop();
    while(!maxHeap.empty && visited[maxHeap.top[1]]) maxHeap.pop();

    if(minHeap.empty)
        out.push("EMPTY");
    else
        out.push(`${maxHeap.top[0]} ${minHeap.top[0]}`);
}

const st = new StringTokenizer();
const t = Number(st.nextToken());
const out = [];
for(let i = 0; i < t; i++)
    runDualPriorityQueue(st, out);
console.log(out.join("\n"));