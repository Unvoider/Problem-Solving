const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const [a, b] = input.split(" ").map(Number);
const out = [a + b, a - b, a * b, Math.trunc(a / b), a % b].join("\n");
console.log(out);