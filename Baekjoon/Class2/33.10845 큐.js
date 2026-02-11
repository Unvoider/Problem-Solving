const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

class Queue { // 연결 리스트 큐
    static Node = class {
        constructor(data, next) { // 연결 리스트 노드
            this.data = data;
            this.next = next;
        }
    }
    #front; // 첫 노드
    #back; // 마지막 노드
    #size;
    constructor() {
        this.#front = this.#back = null;
        this.#size = 0;
    }
    push(data) {
        this.#size++;
        const nodeToPush = new Queue.Node(data, null);
        if(this.#size === 1)
            this.#front = this.#back = nodeToPush;
        else {
            this.#back.next = nodeToPush;
            this.#back = nodeToPush
        }
    }
    pop() {
        if (this.empty) return undefined;
        this.#size--;
        const data = this.#front.data;
        this.#front = this.#front.next;
        if(this.#front === null) this.#back = null;
        return data;
    }
    get size() {
        return this.#size;
    }
    get empty() {
        return this.#size === 0;
    }
    get front() {
        if (this.empty) return undefined;
        return this.#front.data;
    }
    get back() {
        if (this.empty) return undefined;
        return this.#back.data;
    }
}

const n = Number(input[0]);
const nums = new Queue();
const out = [];

for(let i = 1; i <= n; i++) {
    const line = input[i].split(" ");
    const command = line[0].trim();
    let num;
    switch(command) {
        case "push":
            nums.push(Number(line[1]));
            break;
        case "pop":
            num = nums.pop();
            if(num === undefined) out.push("-1");
            else out.push(num);
            break;
        case "size":
            out.push(nums.size);
            break;
        case "empty":
            out.push(nums.empty ? 1 : 0);
            break;
        case "front":
            num = nums.front;
            if(num === undefined) out.push("-1");
            else out.push(num);
            break;
        case "back":
            num = nums.back;
            if(num === undefined) out.push("-1");
            else out.push(num);
            break;
    }
}

console.log(out.join("\n"));

/* 배열 사용
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

class Queue { // 정적 배열 원형 큐
    #arr;
    #front; // 첫 요소
    #back; // 마지막 요소
    #size;
    #maxSize;
    constructor(maxSize) {
        this.#arr = new Array(maxSize);
        this.#front = 0;
        this.#back = -1;
        this.#size = 0;
        this.#maxSize = maxSize;
    }
    forward(idx) {
        return (idx + 1) % this.#maxSize;
    }
    push(data) {
        if (this.full) return;
        this.#size++;
        this.#back = this.forward(this.#back);
        this.#arr[this.#back] = data;
    }
    pop() {
        if (this.empty) return undefined;
        this.#size--;
        const data = this.#arr[this.#front];
        this.#front = this.forward(this.#front);
        return data;
    }
    get size() {
        return this.#size;
    }
    get empty() {
        return this.#size === 0;
    }
    get full() {
        return this.#size === this.#maxSize;
    }
    get front() {
        if (this.empty) return undefined;
        return this.#arr[this.#front];
    }
    get back() {
        if (this.empty) return undefined;
        return this.#arr[this.#back];
    }
}

const n = Number(input[0]);
const nums = new Queue(n);
const out = [];

for(let i = 1; i <= n; i++) {
    const line = input[i].split(" ");
    const command = line[0].trim();
    let num;
    switch(command) {
        case "push":
            nums.push(Number(line[1]));
            break;
        case "pop":
            num = nums.pop();
            if(num === undefined) out.push("-1");
            else out.push(num);
            break;
        case "size":
            out.push(nums.size);
            break;
        case "empty":
            out.push(nums.empty ? 1 : 0);
            break;
        case "front":
            num = nums.front;
            if(num === undefined) out.push("-1");
            else out.push(num);
            break;
        case "back":
            num = nums.back;
            if(num === undefined) out.push("-1");
            else out.push(num);
            break;
    }
}

console.log(out.join("\n"));
*/