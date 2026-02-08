const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/).map(Number);

let cursor = 0;
const t = input[cursor++];
const out = [];
for(let _ = 0; _ < t; _++) {
    const a = input[cursor++];
    const b = input[cursor++];
    out.push(a + b);
}
console.log(out.join("\n"));