const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);
const a = input[1].split(" ").map(Number);
const maxLengths = new Array(n).fill(1);

for(let i = 0; i < n; i++)
    for(let j = 0; j < i; j++) // 각 도착점의 최대 길이 찾기
        if(a[i] > a[j])
            maxLengths[i] = Math.max(maxLengths[i], maxLengths[j] + 1);

console.log(Math.max(...maxLengths));