const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const xn = input[1].split(" ").map(Number);
const sortedXn = Array.from(new Set(xn)).sort((a, b) => a - b); // 중복 제거, 정렬

const compression = new Map(); // Map으로 순서 저장
sortedXn.forEach((sortedX, i) => compression.set(sortedX, i));

const out = xn.map(x => compression.get(x));
console.log(out.join(" "));