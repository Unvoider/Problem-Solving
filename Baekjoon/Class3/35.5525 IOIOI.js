const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);
const m = Number(input[1]);
const s = input[2];

let pCount = 0;
for(let i = 0; i < m - n * 2; i++)
    if(s[i] === "I") { // 시작 문자 찾기
        let oiCount = 0;
        while(i + 2 < m) { // 뒤에 있는 문자 두 개 확인
            if(s[i + 1] === "O" && s[i + 2] === "I") {
                i += 2;
                oiCount++;
                if(oiCount >= n) pCount++;
            }
            else
                break;
        }
    }

console.log(pCount);