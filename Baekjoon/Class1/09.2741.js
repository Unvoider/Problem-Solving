const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const n = Number(input);
const nums = [];
for(let i = 1; i <= n; i++)
    nums.push(i);
console.log(nums.join("\n"));