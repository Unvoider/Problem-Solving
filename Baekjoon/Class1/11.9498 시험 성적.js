const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const score = Number(input);
if(score >= 90) console.log("A");
else if(score >= 80) console.log("B");
else if(score >= 70) console.log("C");
else if(score >= 60) console.log("D");
else console.log("F");