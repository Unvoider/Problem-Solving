const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);
const timeArr = input[1].split(" ").map(Number).sort((a, b) => a - b); // 인출하는 데 걸리는 시간
let minTotal = 0; // 시간 합의 최솟값
for(let i = 0; i < n; i++)
    minTotal += timeArr[i] * (n - i);
console.log(minTotal);