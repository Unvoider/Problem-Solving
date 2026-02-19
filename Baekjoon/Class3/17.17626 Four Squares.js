const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8");

const isSquare = (n) => { // 제곱수인지 확인
    const root = Math.trunc(Math.sqrt(n));
    return root * root === n;
}

const n = Number(input);
const powerMax = Math.trunc(Math.sqrt(n));

const powers = new Array(powerMax + 1).fill(0); // 타뷸레이션
for(let i = 1; i <= powerMax; i++)
    powers[i] = i * i;

if(powers[powerMax] === n) { // 1개
    console.log(1);
    return;
}

for(let i = 1; i <= powerMax; i++) { // 2개
    const remainder = n - powers[i];
    if(remainder < 1)
        break;
    if(isSquare(remainder)) {
        console.log(2);
        return;
    }
}

for(let i = 1; i <= powerMax; i++) // 3개
    for(let j = 1; j <= i; j++) {
        const remainder = n - powers[i] - powers[j];
        if(remainder < 1)
            break;
        if(isSquare(remainder)) {
            console.log(3);
            return;
        }
    }

console.log(4); // 4개