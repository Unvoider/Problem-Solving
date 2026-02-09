const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const notes = input.split(" ").map(Number);
let isAscending = true, isDescending = true;
let prev = notes[0];
for(let i = 1; i < notes.length; i++) {
    const cur = notes[i];
    if(prev >= cur) isAscending = false;
    if(prev <= cur) isDescending = false;
    prev = cur;
}
if(isAscending) console.log("ascending");
else if(isDescending) console.log("descending");
else console.log("mixed");