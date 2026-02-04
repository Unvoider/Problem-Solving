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
let primeN = 0;
for(let num of nums)
    primeN += isPrime(num);
console.log(primeN);