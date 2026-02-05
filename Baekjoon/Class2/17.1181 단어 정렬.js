const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const dictSort = (a, b) => {
    if(a.length !== b.length) // 길이순 정렬
        return a.length - b.length;
    return a < b ? -1 : 1 // 문자순 정렬
}

let out = "";
const words = [...new Set(input.slice(1))]; // 중복 제거
words.sort(dictSort); // 정렬
console.log(words.join("\n"));