// node.js 제출 제한 문제
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const NUM_RANGE = 10001;

let cursor = 0;
const n = Number(input[cursor++]);
const numCounts = new Array(NUM_RANGE).fill(0);
let out = "";
for(let _ = 0; _ < n; _++) { // 계수 정렬
    const num = Number(input[cursor++]);
    numCounts[num]++;
}
for(let i = 1; i < NUM_RANGE; i++) // 출력
    for(let _ = 0; _ < numCounts[i]; _++)
        out += i + "\n";
console.log(out);