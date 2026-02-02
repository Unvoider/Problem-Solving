const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

let [a, b, c] = input.split("\n").map(Number);
console.log(a + b - c);
[a, b, c] = input.split("\n");
console.log(a + b - c);