// node.js 제출 제한 문제
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const NUM_RANGE = 10001;

const n = Number(input[0]);
const numCounts = new Array(NUM_RANGE).fill(0);
const out = [];
for(let i = 1; i <= n; i++) // 계수 정렬
    numCounts[Number(input[i])]++;
for(let i = 1; i < NUM_RANGE; i++) // 출력
    for(let _ = 0; _ < numCounts[i]; _++)
        out.push(i);
console.log(out.join("\n"));