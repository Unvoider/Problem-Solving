const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const MAX_NUM = 10;

const sumCounts = new Array(MAX_NUM + 1).fill(0); // 타뷸레이션
sumCounts[1] = 1; // 1
sumCounts[2] = 2; // 1 + 1, 2
sumCounts[3] = 4; // 1 + 1 + 1, 1 + 2, 2 + 1, 3
for(let i = 4; i <= MAX_NUM; i++)
    sumCounts[i] = sumCounts[i - 3] + sumCounts[i - 2] + sumCounts[i - 1];

const t = Number(input[0]);
const out = [];
for(let i = 1; i <= t; i++)
    out.push(sumCounts[Number(input[i])]);
console.log(out.join("\n"));