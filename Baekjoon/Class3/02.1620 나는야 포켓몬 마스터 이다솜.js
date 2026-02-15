const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

class Pokedex {
    #size
    #indexToName
    #nameToIndex
    constructor(reserveSize) {
        this.#size = 0
        this.#indexToName = new Array(reserveSize + 1)
        this.#indexToName[0] = "Dummy"; // 0번 인덱스 더미 데이터
        this.#nameToIndex = new Map();
    }
    add(name) {
        this.#size++;
        this.#indexToName[this.#size] = name;
        this.#nameToIndex.set(name, this.#size);
    }
    getName(index) {
        return this.#indexToName[index];
    }
    getIndex(name) {
        return this.#nameToIndex.get(name);
    }
}

const [n, m] = input[0].split(" ").map(Number);
const pokedex = new Pokedex(n);
const out = []

for(let i = 1; i <= n; i++) // 이름 등록
    pokedex.add(input[i].trim());

for(let i = n + 1; i <= n + m; i++) { // 검색
    const target = input[i];
    if(isNaN(target[0])) // 이름 검색
        out.push(pokedex.getIndex(target.trim()));
    else // 인덱스 검색
        out.push(pokedex.getName(Number(target)));
}
console.log(out.join("\n"));