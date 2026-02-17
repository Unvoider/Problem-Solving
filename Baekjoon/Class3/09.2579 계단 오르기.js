const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n").map(Number);

const stepsN = input[0];

const maxScores = new Array(stepsN + 1).fill(0); // 타뷸레이션
if(stepsN >= 1) maxScores[1] = input[1];
if(stepsN >= 2) maxScores[2] = input[1] + input[2];
for(let i = 3; i <= stepsN; i++) {
    const leapBefore = input[i] + maxScores[i - 2];
    const noLeapBefore = input[i] + input[i - 1] + maxScores[i - 3];
    maxScores[i] = Math.max(leapBefore, noLeapBefore);
}
console.log(maxScores[stepsN]);