const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);

const triangle = []; // 삼각형 입력
for(let i = 1; i <= n; i++)
    triangle.push(input[i].split(" ").map(Number));

for(let i = n - 1; i > 0; i--) // 맨아래 레벨부터 더 큰 자식 누적하기
    for(let j = 0; j < i; j++)
        triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);

console.log(triangle[0][0]);