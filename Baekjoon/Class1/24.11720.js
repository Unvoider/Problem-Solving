const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const nums = input[1];
let total = 0;
for(const num of nums)
    total += Number(num);
console.log(total);

/*
const nums = input[1];
let total = nums.split("").reduce((acc, cur) => acc + Number(cur), 0);
console.log(total);
*/