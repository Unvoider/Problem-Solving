const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const out = [];

const nums = input[1].split(" ").map(Number);
const sums = new Array(n + 1).fill(0);
for(let i = 1; i <= n; i++)
    sums[i] = sums[i - 1] + nums[i - 1];

for(let k = 2; k < m + 2; k++) {
    const [i, j] = input[k].split(" ").map(Number);
    out.push(sums[j] - sums[i - 1]);
}
console.log(out.join("\n"));