const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const k = Number(input[0]);
const nums = [];

for(let i = 1; i <= k; i++) {
    const num = Number(input[i]);
    if(num === 0) nums.pop() // 0이면 pop
    else nums.push(num)
}
console.log(nums.reduce((acc, cur) => acc + cur, 0));