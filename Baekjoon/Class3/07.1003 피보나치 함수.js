// 반복 동적 프로그래밍
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n").map(Number);

const FIB_MAX = 40;

// 타뷸레이션
const zeroCount = new Array(FIB_MAX + 2).fill(0);
zeroCount[0] = 1;
for(let i = 2; i < FIB_MAX + 2; i++)
    zeroCount[i] = zeroCount[i - 1] + zeroCount[i - 2];

const t = input[0];
const out = [];
for(let i = 1; i <= t; i++) {
    const n = input[i];
    out.push(`${zeroCount[n]} ${zeroCount[n + 1]}`);
}
console.log(out.join("\n"));

/* 재귀 동적 프로그래밍
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n").map(Number);

const FIB_MAX = 40;

// 메모이제이션
const zeroCount = new Array(FIB_MAX + 2).fill(0);
zeroCount[0] = 1;

const countFib = (n) => {
    if(n < 2) return;
    if(zeroCount[n] !== 0) return;
    countFib(n - 1);
    countFib(n - 2);
    zeroCount[n] = zeroCount[n - 1] + zeroCount[n - 2];
}

const t = input[0];
const out = [];
for(let i = 1; i <= t; i++) {
    const n = input[i];
    countFib(n + 1);
    out.push(`${zeroCount[n]} ${zeroCount[n + 1]}`);
}
console.log(out.join("\n"));
*/