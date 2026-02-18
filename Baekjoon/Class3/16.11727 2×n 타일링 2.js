const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8");

const DIVISOR = 10007;

const n = Number(input);

const tilingCases = new Array(n + 1).fill(0); // 타뷸레이션
if(n >= 1) tilingCases[1] = 1;
if(n >= 2) tilingCases[2] = 3;
for(let i = 3; i <= n; i++)
    tilingCases[i] = (tilingCases[i - 2] * 2 + tilingCases[i - 1]) % DIVISOR;

console.log(tilingCases[n]);