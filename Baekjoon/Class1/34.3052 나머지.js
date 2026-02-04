const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const nums = input.split("\n").map((num) => num % 42);
const numSet = new Set(nums);
console.log(numSet.size);