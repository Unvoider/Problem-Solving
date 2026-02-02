const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

let cursor = 0;
const notes = input.split(" ").map(Number);
let isAscending = true, isDescending = true;
let prev = notes[cursor++];
for(; cursor < notes.length; cursor++) {
    const cur = notes[cursor];
    if(prev >= cur) isAscending = false;
    if(prev <= cur) isDescending = false;
    prev = cur;
}
if(isAscending) console.log("ascending");
else if(isDescending) console.log("descending");
else console.log("mixed");