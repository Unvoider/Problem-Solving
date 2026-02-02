const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const [a, b] = input.split(" ").map(Number);
if(a > b) console.log(">");
else if(a < b) console.log("<");
else console.log("==");