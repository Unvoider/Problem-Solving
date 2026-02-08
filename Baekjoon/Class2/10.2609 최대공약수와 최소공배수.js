// 유클리트 호제법
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const gcd = (a, b) => { // greatest common divisor
    while(b)
        [a, b] = [b, a % b];
    return a;
}

const lcm = (a, b) => { // least common multiple
    return a * b / gcd(a, b);
}

[a, b] = input.split(" ").map(Number);
console.log(`${gcd(a, b)}\n${lcm(a, b)}`)