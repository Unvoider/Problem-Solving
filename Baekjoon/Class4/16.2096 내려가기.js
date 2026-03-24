const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const TABLE_SIZE = 3;

const n = Number(input[0]);

let prevMaxTable = new Array(3).fill(0);
let prevMinTable = new Array(3).fill(0);
let maxTable = input[1].split(" ").map(Number); // 첫 열
let minTable = [...maxTable];

for(let i = 2; i <= n; i++) {
    prevMaxTable = [...maxTable]; // 슬라이딩 윈도우
    prevMinTable = [...minTable];
    maxTable = input[i].split(" ").map(Number); // 다음 열
    minTable = [...maxTable];

    maxTable[0] += Math.max(prevMaxTable[0], prevMaxTable[1]); // 최댓값 누적
    maxTable[1] += Math.max(...prevMaxTable);
    maxTable[2] += Math.max(prevMaxTable[1], prevMaxTable[2]);
    minTable[0] += Math.min(prevMinTable[0], prevMinTable[1]); // 최솟값 누적
    minTable[1] += Math.min(...prevMinTable);
    minTable[2] += Math.min(prevMinTable[1], prevMinTable[2]);
}

console.log(`${Math.max(...maxTable)} ${Math.min(...minTable)}`);