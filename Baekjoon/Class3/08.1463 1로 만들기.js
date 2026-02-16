const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);

// 타뷸레이션
const countTable = new Array(n + 1).fill(0);
for(let i = 2; i <= n; i++) {
    let a, b, c;
    a = b = c = countTable[i - 1] + 1;
    if(i % 3 == 0) b = countTable[Math.trunc(i / 3)] + 1; // 3으로 나눠 떨어지면
    if(i % 2 == 0) c = countTable[Math.trunc(i / 2)] + 1; // 2로 나눠 떨어지면
    countTable[i] = Math.min(a, b, c);
}
console.log(countTable[n]);