const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").split("\n");

const vps = (ps) => { // valid parenthesis string
    let count = 0;
    for(const ch of ps)
        if(ch === "(") // 왼쪽 괄호 count++
            count++;
        else // 오른쪽 괄호 count--
            if(count === 0) return false; // count 빔
            else count--;
    return count === 0; // 남은 괄호 없으면 성공
}

const t = Number(input[0]);
const out = [];
for(let i = 1; i <= t; i++)
    out.push(vps(input[i].trim()) ? "YES" : "NO");
console.log(out.join("\n"));