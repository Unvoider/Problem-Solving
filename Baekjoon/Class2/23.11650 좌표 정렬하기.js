const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/).map(Number);

let cursor = 0;
const n = input[cursor++];
const coords = [];
for(let _ = 0; _ < n; _++)
    coords.push([input[cursor++], input[cursor++]]); // [x, y]

coords.sort((c1, c2) => c1[0] - c2[0] || c1[1] - c2[1]);
console.log(coords.map(coord => `${coord[0]} ${coord[1]}`).join("\n"));