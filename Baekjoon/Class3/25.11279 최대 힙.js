const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

class MaxHeap {
    #heap;
    constructor() {
        this.#heap = [null]; // root 인덱스 1
    }
    get empty() {
        return this.#heap.length === 1;
    }
    push(data) {
        let inPos = this.#heap.length; // 마지막 인덱스를 삽입 위치로
        let parent = inPos >> 1;
        this.#heap.push(null);
        // 삽입 위치가 root가 아니고 자식 값이 부모 값보다 큰 동안
        while(inPos !== 1 && data > this.#heap[Math.trunc(parent)]) {
            this.#heap[inPos] = this.#heap[Math.trunc(parent)]; // 부모를 자식으로
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
            if(child + 1 < heapLength && this.#heap[child] < this.#heap[child + 1])
                child += 1; // 왼쪽/오른쪽 자식 중 더 큰 값 고르기
            if(last >= this.#heap[child]) break; // 부모 값이 자식 값보다 작은 동안
            this.#heap[inPos] = this.#heap[child]; // 자식을 부모로
            inPos = child; // 부모를 자식으로
            child = inPos << 1;
        }
        this.#heap[inPos] = last;
        return data;
    }
}

const n = Number(input[0]);
const out = [];

const maxHeap = new MaxHeap();
for(let i = 1; i <= n; i++) {
    const x = Number(input[i]);
    if(x === 0)
        if(maxHeap.empty)
            out.push(0);
        else
            out.push(maxHeap.pop());
    else
        maxHeap.push(x);
}
console.log(out.join("\n"));