const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/).map(Number);

let cursor = 0;
const t = input[cursor++];
const out = [];
for(let _ = 0; _ < t; _++) {
    const h = input[cursor++];
    const w = input[cursor++];
    const n = input[cursor++];
    const y = (n - 1) % h + 1;
    const x = Math.floor((n - 1) / h + 1);
    out.push(y * 100 + x);
}
console.log(out.join("\n"));