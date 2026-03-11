const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

class Heap {
    #cmp;
    #heap;
    constructor(cmp) {
        this.#cmp = cmp;
        this.#heap = [null]; // root 인덱스 1
    }
    get empty() {
        return this.#heap.length === 1;
    }
    push(data) {
        let inPos = this.#heap.length; // 마지막 인덱스를 삽입 위치로
        let parent = inPos >> 1;
        this.#heap.push(null); // 끝 자리 만들기
        // 삽입 위치가 root가 아니고 자식 값이 부모 값보다 작은 동안
        while(inPos !== 1 && this.#cmp(data, this.#heap[Math.trunc(parent)]) < 0) {
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

const n = Number(input[0]);
const out = [];

const q = new Heap((n1, n2) => {
    const abs1 = Math.abs(n1), abs2 = Math.abs(n2);
    if(abs1 === abs2)
        return n1 - n2;
    return abs1 - abs2;
}); // 절댓값 최소 힙
for(let i = 1; i <= n; i++) {
    const x = Number(input[i]);
    if(x === 0) // 팝
        if(q.empty) // 빔
            out.push(0);
        else
            out.push(q.pop());
    else // 푸시
        q.push(x);
}
console.log(out.join("\n"));