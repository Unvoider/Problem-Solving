const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

class Stack { // 연결 리스트 스택
    static Node = class {
        constructor(data, next) { // 연결 리스트 노드
            this.data = data;
            this.next = next;
        }
    }
    #top; // 첫 노드
    #size;
    constructor() {
        this.#top = null;
        this.#size = 0;
    }
    push(data) {
        this.#size++;
        const nodeToPush = new Stack.Node(data, this.#top);
        this.#top = nodeToPush;
    }
    pop() {
        if (this.empty) return undefined;
        this.#size--;
        const data = this.#top.data;
        this.#top = this.#top.next;
        return data;
    }
    get size() {
        return this.#size;
    }
    get empty() {
        return this.#size === 0;
    }
    get top() {
        if (this.empty) return undefined;
        return this.#top.data;
    }
}

const n = Number(input[0]);
const nums = new Stack();
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
        case "top":
            num = nums.top;
            if(num === undefined) out.push("-1");
            else out.push(num);
            break;
    }
}

console.log(out.join("\n"));

/* 배열 사용
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);
const nums = [];
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
            out.push(nums.length ? nums.pop() : -1);
            break;
        case "size":
            out.push(nums.length);
            break;
        case "empty":
            out.push(nums.length ? 0 : 1);
            break;
        case "top":
            out.push(nums.length ? nums[nums.length - 1] : -1);
            break;
    }
}

console.log(out.join("\n"));
*/