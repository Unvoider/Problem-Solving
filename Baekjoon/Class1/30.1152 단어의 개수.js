const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(" ");

// .split()은 문자열이 비어있을 때 [""]을 반환함
if(input[0] === "") console.log("0");
else console.log(input.length);