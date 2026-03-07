const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);

const meetings = [];
for(let i = 1; i <= n; i++)
    meetings.push(input[i].split(" ").map(Number));
meetings.sort((a, b) => a[1] - b[1] || a[0] - b[0]); // 끝나는 시간 기준 정렬

let maxCount = 0;
let prevEnd = 0;
for(const [start, end] of meetings)
    if(prevEnd <= start) { // 다음 미팅 추가
        maxCount++;
        prevEnd = end;
    }

console.log(maxCount);