const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const [_, x] = input[0].split(" ").map(Number);
const a = input[1].split(" ").map(Number);
const out = a.filter(num => num < x).join(" ");
console.log(out);

/*
const [_, x] = input[0].split(" ").map(Number);
const a = input[1].split(" ").map(Number);
let out = "";
for(const num of a)
    if(num < x)
        out += num + " ";
console.log(out);
*/