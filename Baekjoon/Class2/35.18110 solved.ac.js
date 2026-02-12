const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n").map(Number);

const n = input[0];
if(n === 0) {
    console.log(0);
    process.exit();
}

const opinions = input.slice(1).sort((a, b) => a - b); // 정렬
let total = 0;
const exclusion = Math.round(n * 0.15); // 절사 범위
for(let i = exclusion; i < n - exclusion; i++) // 절사
    total += opinions[i];
console.log(Math.round(total / (n - 2 * exclusion))); // 평균