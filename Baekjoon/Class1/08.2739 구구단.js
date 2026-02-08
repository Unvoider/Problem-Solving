const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const n = Number(input);
const out = [];
for(let i = 1; i <= 9; i++)
    out.push(`${n} * ${i} = ${n * i}`);
console.log(out.join("\n"));