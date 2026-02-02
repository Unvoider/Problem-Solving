const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n").map(Number);

let cursor = 0;
const t = input[cursor++];
const apt = Array.from({ length: 15 }, () => new Array(15)); // 타뷸레이션
let out = "";

for(let i = 0; i < 15; i++) {
    apt[0][i] = i + 1; // 0층 초기화
    apt[i][0] = 1; // 1호 초기화
}
for(let i = 1; i < 15; i++) // 전체 계산
    for (let j = 1; j < 15; j++)
        apt[i][j] = apt[i - 1][j] + apt[i][j - 1]; // 아랫집 + 왼쪽 집

for(let _ = 0; _ < t; _++) {
    const k = input[cursor++];
    const n = input[cursor++];
    out += apt[k][n - 1] + "\n";
}
console.log(out);