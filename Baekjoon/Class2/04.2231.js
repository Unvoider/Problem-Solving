const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const n = Number(input);
let out = 0;
// 999999의 각 자리를 모두 더해도 기껏해야 54가 나오므로 N - 54부터 시작함
for(let i = Math.max(n - 54, 0); i < n; i++) {
    let num = i, total = i;
    while(num !== 0) {
        total += num % 10; // 각 자리 수 더하기
        num = Math.trunc(num / 10);
    }
    if(total === n) { // 찾음
        out = i;
        break;
    }
}
console.log(String(out));

/* String으로 변환하여 각 자리 수 더하기
const n = Number(input);
let out = 0;
// 999999의 각 자리를 모두 더해도 기껏해야 54가 나오므로 N - 54부터 시작함
for(let i = Math.max(n - 54, 0); i < n; i++) {
    if(i.toString().split("").reduce((acc, cur) => acc + Number(cur), 0) + i === n) {
        out = i;
        break;
    }
}
console.log(String(out));
*/