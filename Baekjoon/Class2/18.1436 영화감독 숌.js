const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const n = Number(input);
let title = 665;

for(let _ = 0; _ < n; _++) {
    let found = false;
    while(!found) {
        title++;
        let dividend = title, sixCount = 0;
        while(dividend !== 0) {
            if (dividend % 10 === 6) { // 6이 세 번 연속되는 수 찾기
                sixCount++;
                if (sixCount === 3)
                    found = true;
            }
            else
                sixCount = 0;
            dividend = Math.trunc(dividend / 10);
        }
    }
}
console.log(title);

/* 문자열 이용
const n = Number(input);
let count = 1, title = 665;

while(count <= n) {
    title++;
    if(String(title).includes("666"))
        count++;
}
console.log(title);
*/