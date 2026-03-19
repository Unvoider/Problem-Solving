const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

/*
a^n
= a if n==1,
= (a^(n/2))^2 if n%2==0,
= a*(a^((n-1)/2))^2 if n%2==1
*/

const powerMod = (base, exp, div) => {
    if(exp === 1n) return base % div; // 1일 때
    const half = powerMod(base, exp / 2n, div);
    const whole = (half * half) % div;
    if(exp % 2n === 0n) return whole; // 짝수일 때
    return ((base % div) * whole) % div; // 홀수일 때
};

const [a, b, c] = input.split(" ").map(BigInt);
console.log(Number(powerMod(a, b, c)));