const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(" ").map(Number);

const [n, k] = input;
const people = Array.from({ length: n }, (_, i) => i + 1);
const out = [];

let idx = 0;
while(people.length !== 0) {
    idx = (idx + k - 1) % people.length; // k - 1번 이동
    out.push(people.splice(idx, 1)[0]); // k번째 사람
}
console.log(`<${out.join(", ")}>`);