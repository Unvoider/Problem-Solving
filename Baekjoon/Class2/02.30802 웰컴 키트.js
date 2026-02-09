const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);
const tCounts = input[1].split(" ").map(Number);
const [tBundle, pBundle] = input[2].split(" ").map(Number);

// 티셔츠 묶음
let t = 0;
for(const tCount of tCounts)
    t += Math.ceil(tCount / tBundle);
    // t += Math.trunc((tCount + tBundle - 1) / tBundle);

// 펜 묶음과 낱개
const p = Math.trunc(n / pBundle);
const pRest = n % pBundle;

console.log(`${t}\n${p} ${pRest}`);