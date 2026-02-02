const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

let max = -1, max_index = -1;
const a = input.split("\n").map(Number);
for(let i = 0; i < a.length; i++) {
    if(a[i] > max) {
        max = a[i];
        max_index = i;
    }
}
console.log(`${max}\n${max_index + 1}`);

/*
const a = input.split("\n").map(Number);
const max = Math.max(...a);
const max_index = a.indexOf(max);
console.log(`${max}\n${max_index + 1}`);
*/