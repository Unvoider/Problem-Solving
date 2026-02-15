// node.js 제출 제한 문제
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

class BitmaskSet { // BigInt 비트마스크 세트
    #set;
    constructor() {
        this.#set = 0n;
    }
    add(data) {
        this.#set |= 1n << BigInt(data - 1);
    }
    remove(data) {
        this.#set &= ~(1n << BigInt(data - 1));
    }
    check(data) {
        return (this.#set & (1n << BigInt(data - 1))) !== 0n;
    }
    toggle(data) {
        this.#set ^= 1n << BigInt(data - 1);
    }
    all() {
        this.#set = (1n << 21n) - 1n;
    }
    empty() {
        this.#set = 0n;
    }
}

const m = Number(input[0]);
const s = new BitmaskSet();
const out = [];

for(let i = 1; i <= m; i++) {
    const line = input[i].split(" ");
    const command = line[0].trim();
    switch(command) {
        case "add":
            s.add(Number(line[1]));
            break;
        case "remove":
            s.remove(Number(line[1]));
            break;
        case "check":
            out.push(s.check(Number(line[1])) ? 1 : 0);
            break;
        case "toggle":
            s.toggle(Number(line[1]));
            break;
        case "all":
            s.all();
            break;
        case "empty":
            s.empty();
            break;
    }
}
console.log(out.join("\n"));