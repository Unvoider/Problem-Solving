const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const [_, ...nums] = input.map(Number);
console.log(nums.sort((a, b) => a - b).join("\n"));