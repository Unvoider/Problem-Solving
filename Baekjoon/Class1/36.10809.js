const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const s = input;
const firstAppearance = new Array(26).fill(-1);
for(let i = 0; i < s.length; i++) {
    const index = s.charCodeAt(i) - 97; // 'a' = 97
    if(firstAppearance[index] == -1)
        firstAppearance[index] = i;
}
console.log(firstAppearance.join(" "));