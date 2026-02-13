// 에라토스테네스의 체 O(NloglogN)
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const getSieve = (max) => {
    const isPrime = new Array(max + 1).fill(true);
    isPrime[0] = isPrime[1] = false;
    for(let i = 2; i * i <= max; i++) // 2부터 sqrt(max)까지 소수 찾기
        if(isPrime[i])
            for(let j = i * i; j <= max; j += i) // 소수면 제곱부터 배수를 지우기
                isPrime[j] = false;
    return isPrime;
}

const [n, m] = input.split(" ").map(Number);
const isPrime = getSieve(m);
const out = [];
for(let i = n; i <= m; i++)
    if(isPrime[i])
        out.push(i);
console.log(out.join("\n"));