const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/);

let cursor = 0;
const t = Number(input[cursor++]);
let p = "";
for(let _ = 0; _ < t; _++) {
    const r = Number(input[cursor++]);
    const s = input[cursor++];
    for(const ch of s) p += ch.repeat(r);
    p += "\n";
}
console.log(p);