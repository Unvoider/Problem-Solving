const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const n = Number(input);
let out = "";
for(let i = 1; i <= n; i++)
    out += "*".repeat(i) + "\n";
console.log(out);