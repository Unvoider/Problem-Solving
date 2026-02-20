const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const sum = (terms) => terms.split("+").map(Number).reduce((acc, cur) => acc + cur, 0);

const [toAdd, ...toSub] = input.split("-");
// "-"가 나오기 전까지 더하기, "-"가 나오면 빼기
const total = sum(toAdd) - toSub.reduce((acc, cur) => acc + sum(cur), 0);
console.log(total);