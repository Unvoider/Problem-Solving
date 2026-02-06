const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/).map(Number);

let cursor = 0;
const n = input[cursor++];
const weights = new Array(n), heights = new Array(n);
for(let i = 0; i < n; i++) {
    weights[i] = input[cursor++];
    heights[i] = input[cursor++];
}

const ranks = new Array(n).fill(1); // i의 등수
for(let i = 0; i < n; i++)
    for (let j = 0; j < n; j++)
        if (weights[i] < weights[j] && heights[i] < heights[j])
            ranks[i]++;
console.log(ranks.join(" "));