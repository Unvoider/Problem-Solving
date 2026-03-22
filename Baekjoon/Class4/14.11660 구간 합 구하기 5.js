const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const board = Array.from({ length: n }, (_, i) => input[i + 1].split(" ").map(Number));
const out = [];

const acc = Array.from({ length: n + 1 }, () => new Array(n + 1).fill(0));
for(let i = 1; i <= n; i++) // 누적 합
    for(let j = 1; j <= n; j++)
        acc[i][j] = board[i - 1][j - 1] + acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1];

for(let i = n + 1; i <= n + m; i++){ // 출력
    const [x1, y1, x2, y2] = input[i].split(" ").map(Number);
    out.push(acc[x2][y2] + acc[x1 - 1][y1 - 1] - acc[x2][y1 - 1] - acc[x1 - 1][y2]);
}

console.log(out.join("\n"));