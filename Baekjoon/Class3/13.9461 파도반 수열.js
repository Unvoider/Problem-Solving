const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n").map(Number);

const MAX_NUM = 100;

const padovan = new Array(MAX_NUM + 1).fill(0) // 타뷸레이션
padovan[1] = padovan[2] = padovan[3] = 1;
padovan[4] = padovan[5] = 2;
for(let i = 6; i <= MAX_NUM; i++)
    padovan[i] = padovan[i - 5] + padovan[i - 1];

const t = input[0];
const out = [];
for(let i = 1; i <= t; i++)
    out.push(padovan[input[i]])
console.log(out.join("\n"));