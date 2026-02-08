const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/).map(Number);

let cursor = 0;
const out = [];
while(true) {
    const a = input[cursor++];
    const b = input[cursor++];
    if(a == 0 && b == 0) break;
    out.push(a + b);
}
console.log(out.join("\n"));