const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

let min = 10000001, max = -10000001;
const a = input[1].split(" ").map(Number);
for(const num of a) {
    if(num < min) min = num;
    if(num > max) max = num;
}
console.log(`${min} ${max}`);
// console.log(`${Math.min(...a)} ${Math.max(...a)}`);