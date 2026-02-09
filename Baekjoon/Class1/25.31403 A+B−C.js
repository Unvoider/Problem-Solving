const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

let [a, b, c] = input.map(Number);
console.log(a + b - c);
[a, b, c] = input;
console.log(a + b - c);