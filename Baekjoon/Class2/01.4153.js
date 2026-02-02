const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

let out = "";
for(const line of input) {
    const sides = line.split(" ").map(Number);
    if(sides[0] === 0 && sides[1] === 0 && sides[2] === 0)
        break;
    sides.sort((x, y) => x - y);
    if(sides[0] * sides[0] + sides[1] * sides[1] === sides[2] * sides[2])
        out += "right\n"
    else
        out += "wrong\n"
}
console.log(out);

/*
let out = "";
for(const line of input) {
    const [a, b, c] = line.split(" ").map(Number);
    if(a === 0 && b === 0 && c === 0)
        break;
    if(a * a + b * b === c * c
        || b * b + c * c === a * a
        || c * c + a * a === b * b)
        out += "right\n"
    else
        out += "wrong\n"
}
console.log(out);
*/