const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/).map(Number);

let cursor = 0;
const t = input[cursor++];
let out = "";
for(let _ = 0; _ < t; _++) {
    const a = input[cursor++];
    const b = input[cursor++];
    out += a + b + "\n";
}
console.log(out);