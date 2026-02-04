const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const [a, b, c] = input.split("\n").map(Number);
let product = a * b * c;
const count = new Array(10).fill(0);
while(product !== 0) {
    const remainder = product % 10;
    count[remainder]++;
    product = Math.trunc(product / 10);
}
console.log(count.join("\n"));

/*
const [a, b, c] = input.split("\n").map(Number);
const product = String(a * b * c);
const count = new Array(10).fill(0);
for(const ch of product)
    count[Number(ch)]++;
console.log(count.join("\n"));
*/