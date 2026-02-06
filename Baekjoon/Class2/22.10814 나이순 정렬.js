const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/);

let cursor = 0;
const n = Number(input[cursor++]);
const people = [];
for(let _ = 0; _ < n; _++)
    people.push([Number(input[cursor++]), input[cursor++]]);

people.sort((p1, p2) => p1[0] - p2[0]);
console.log(people.map(person => `${person[0]} ${person[1]}`).join("\n"));