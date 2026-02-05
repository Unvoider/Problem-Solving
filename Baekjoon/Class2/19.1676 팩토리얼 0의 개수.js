const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const n = Number(input);
let fiveCount = 0;

// 곱해진 10(2 * 5의 쌍) 개수 세기
// 소인수분해 시 항상 2보다 5가 적으므로 5의 개수만 세면 됨
for(let i = 5; i <= n; i *= 5)
    fiveCount += Math.floor(n / i);
console.log(fiveCount);