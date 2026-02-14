const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);
const numStack = [0]; // top 접근을 위한 더미 데이터
const out = [];

let numToPush = 1;
for(let i = 1; i <= n; i++) {
    let numToPop = Number(input[i]);
    while(numStack.at(-1) < numToPop) { // pop할 숫자가 없으면
        numStack.push(numToPush++); // push하기
        out.push("+");
    }
    if (numStack.at(-1) > numToPop) { // top이 pop할 숫자 초과(실패)
        out.length = 0;
        out.push("NO");
        break;
    }
    numStack.pop(); // pop할 숫자 찾음
    out.push("-");
}
console.log(out.join("\n"));