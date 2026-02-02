const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").split("\n");

function isPalindrome(str) {
    const len = str.length;
    for(let i = 0; i < len / 2; i++) // 절반까지 비교
        if (str.charAt(i) !== str.charAt(len - 1 - i)) return false;
    return true;
}

let cursor = 0;
let out = "";
while(true) {
    const str = input[cursor++].trim();
    if(str === "0") break;
    // if(str === str.split("").reverse().join(""))
    if(isPalindrome(str))
        out += "yes\n";
    else
        out += "no\n";
}
console.log(out)