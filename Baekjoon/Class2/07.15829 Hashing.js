const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const CHAR_START = "a".charCodeAt(0) - 1;
const R = 31n, M = 1234567891n;

const getHash = (str, len) => {
    let hash = 0n, power = 1n;
    for(let i = 0; i < len; i++) {
        // 오버플로우를 방지하기 위해 hash와 power에 나머지 연산
        hash = (hash + BigInt(str.charCodeAt(i) - CHAR_START) * power) % M;
        power = power * R % M;
    }
    return hash;
}

const l = Number(input[0]);
const str = input[1].trim();
console.log(String(getHash(str, l)));