const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const nums = input.split(" ").map(Number);
let total = 0;
for(const num of nums)
    total += num * num; // num ** 2
console.log(total % 10);

/*
const nums = input.split(" ").map(Number);
const total = nums.reduce((acc, num) => acc + num * num, 0);
console.log(total % 10);
*/