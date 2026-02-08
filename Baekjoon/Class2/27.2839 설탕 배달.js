// 반복 동적 프로그래밍
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const INF = 5001;

const n = Number(input);
const bagCounts = new Array(n + 1).fill(INF); // 타뷸레이션
bagCounts[3] = 1;
if (n >= 5) bagCounts[5] = 1;

for(let i = 6; i <= n; i++)
    bagCounts[i] = Math.min(bagCounts[i - 3], bagCounts[i - 5]) + 1; // 더 적은 봉지 수에 하나 추가

if(bagCounts[n] >= INF) console.log("-1");
else console.log(bagCounts[n]);

/* 그리디
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const n = Number(input);
let bagCount = -1;

for(let fiveKg = Math.floor(n / 5); fiveKg >= 0; fiveKg--) { // 5kg 봉지 최대부터 0개까지
    const remain = n - (5 * fiveKg);
    if(remain % 3 === 0) { // 나머지가 3으로 나눠 떨어지면 종료
        bagCount = fiveKg + Math.floor(remain / 3);
        break;
    }
}
console.log(bagCount);
*/

/* 재귀 동적 프로그래밍
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const INF = 5001;

const countBags = (kg, bagCounts) => {
    if(kg <= 5) return bagCounts[kg];
    if(bagCounts[kg] === INF) // 아직 계산 안 됨
        // 더 적은 봉지 수에 하나 추가
        bagCounts[kg] = Math.min(countBags(kg - 3, bagCounts), countBags(kg - 5, bagCounts)) + 1;
    return bagCounts[kg];
}

const n = Number(input);
const bagCounts = new Array(n + 1).fill(INF); // 메모이제이션
bagCounts[3] = 1;
if (n >= 5) bagCounts[5] = 1;

const bagCount = countBags(n, bagCounts);
if(bagCount >= INF) console.log("-1");
else console.log(bagCount);
*/