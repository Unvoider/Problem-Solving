const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const PAIRS = {")": "(", "]": "["}

const balancedWorld = (str) => {
    const brackets = [];
    for(const ch of str)
        if(ch === "(" || ch === "[") // 왼쪽 괄호 push
            brackets.push(ch);
        else if(ch === ")" || ch === "]") { // 오른쪽 괄호 pop
            if(brackets.length === 0) return false; // 스택 빔
            if(brackets.pop() !== PAIRS[ch]) // 괄호 짝 안 맞음
                return false;
        }
    return brackets.length === 0; // 남은 괄호 없으면 성공
}

const out = [];
for(const str of input) {
    if(str === ".") break;
    out.push(balancedWorld(str) ? "yes" : "no");
}
console.log(out.join("\n"));