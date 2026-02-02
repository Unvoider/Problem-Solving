const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const s = input[0];
const i = Number(input[1]);
console.log(s[i - 1]);