// 에라토스테네스의 체 O(NloglogN)
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/);

const getSieve = (max) => {
    const isPrime = new Array(max + 1).fill(true);
    isPrime[0] = isPrime[1] = false;
    for(let i = 2; i * i <= max; i++) // 2부터 sqrt(1000)까지 소수 찾기
        if(isPrime[i])
            for(let j = i * i; j <= max; j += i) // 소수면 제곱부터 배수를 지우기
                isPrime[j] = false;
    return isPrime;
}

let cursor = 0;
const [_, ...nums] = input.map(Number);
let primeCount = 0;
let isPrime = getSieve(1000);
for(let num of nums)
    primeCount += isPrime[num];
// const primeCount = nums.filter((num) => isPrime[num]).length
console.log(primeCount);

/* 홀수만 찾기
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/);

function isPrime(num) {
    if(num <= 1) return 0;
    if(num == 2) return 1;
    if(num % 2 == 0) return 0;
    for(let i = 3; i * i <= num; i += 2)
        if(num % i == 0) return 0;
    return 1;
}

let cursor = 0;
const [_, ...nums] = input.map(Number);
let primeCount = 0;
for(let num of nums)
    primeCount += isPrime(num);
console.log(primeCount);
*/