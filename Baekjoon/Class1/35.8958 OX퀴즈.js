const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/);

let cursor = 0;
const n = input[cursor++];
const out = [];
for(let i = 0; i < n; i++) {
    let score = 0, total = 0;
    const str = input[cursor++];
    for(const ch of str)
        if(ch === "O")
            total += ++score;
        else score = 0
    out.push(total);
}
console.log(out.join("\n"));