const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

let [n, k] = input[0].split(" ").map(Number);

const coins = new Array(n) // 동전 종류
for(let i = 1; i <= n; i++)
    coins[n - i] = input[i]; // 내림차순

let coinCount = 0; // 동전 개수
for(const coin of coins) {
    if(k === 0) break;
    coinCount += Math.floor(k / coin);
    k %= coin;
}
console.log(coinCount);