const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const binomialCoefficient = (n, k) => {
    let result = 1;
    if(k > n / 2) // k가 n의 절반보다 크면 n - k로 교체
        k = n - k;
    for(let i = 1; i <= k; i++) {
        result *= n + 1 - i;
        result /= i;
    }
    return result;
}

const [n, k] = input.split(" ").map(Number);
console.log(binomialCoefficient(n, k));