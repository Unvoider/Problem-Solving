const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const year = Number(input);
if(year % 4 === 0 && (year % 100 !== 0 || year % 400 === 0))
    console.log("1");
else
    console.log("0");