const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

let [h, m] = input.split(" ").map(Number);
m -= 45;
if(m < 0) {
    m += 60;
    h -= 1;
    if(h < 0)
        h += 24;
}
console.log(`${h} ${m}`);