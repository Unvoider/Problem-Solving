const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const testCase = Number(input[0]);
const out = [];

let cursor = 1;
for(let _ = 0; _ < testCase; _++) {
    const n = Number(input[cursor++]);
    
    const clothes = new Map(); // 옷의 종류
    for(let _ = 0; _ < n; _++) {
        const [_, type] = input[cursor++].trim().split(" ");
        clothes.set(type, (clothes.get(type) || 0) + 1);
    }

    let cases = 1; // 옷을 입는 경우의 수
    for(const val of clothes.values())
        cases *= val + 1;
    out.push(cases - 1);
}

console.log(out.join("\n"));