const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const [a, b, v] = input.split(" ").map(Number);
// 첫 상승을 제외한 거리: v - a
// 매일 상승 거리: a - b
console.log(Math.ceil((v - a) / (a - b)) + 1);
// 위의 전개식:
// console.log(Math.trunc((v - b - 1) / (a - b)) + 1);