const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);
const scores = input[1].split(" ").map(Number);
let m = 0, total = 0;
for(const score of scores) {
    total += score;
    if(score > m)
        m = score
}
console.log((total / m * 100) / n);
// console.log((scores.reduce((acc, cur) => acc + cur, 0) / Math.max(...scores) * 100) / n);