const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(" ");

const a = Number(input[0]);
let b = Number(input[1]);
let depth = 1;

while(b > a) {
    if(b % 2 === 0) // 2를 곱한다
        b >>= 1;
    else if(b % 10 === 1) // 1을 수의 가장 오른쪽에 추가한다
        b = Math.trunc(b / 10);
    else // 미리 종료
        break;
    depth++;
}

console.log(a === b ? depth : -1);