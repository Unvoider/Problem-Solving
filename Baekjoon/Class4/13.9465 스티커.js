const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const t = Number(input[0]);
const out = [];

let cursor = 1;
for(let _ = 0; _ < t; _++) {
    const n = Number(input[cursor++]);
    scores = Array.from({ length : 2 }, () => input[cursor++].split(" ").map(Number));

    if(n !== 1) {
        scores[0][1] += scores[1][0] // 위 뗌
        scores[1][1] += scores[0][0] // 아래 뗌
        for(let i = 2; i < n; i++) {
            scores[0][i] += Math.max(scores[1][i - 1], scores[1][i - 2]) // 위 뗌
            scores[1][i] += Math.max(scores[0][i - 1], scores[0][i - 2]) // 아래 뗌
        }
    }
    out.push(Math.max(scores[0][n - 1], scores[1][n - 1]))
}

console.log(out.join("\n"));