const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);
let [r, g, b] = input[1].split(" ").map(Number);

for(let i = 2; i <= n; i++) {
    const prevR = r, prevG = g, prevB = b;
    
    [r, g, b] = input[i].split(" ").map(Number);
    r += Math.min(prevG, prevB); // 다른 색 중 최솟값 더하기
    g += Math.min(prevR, prevB);
    b += Math.min(prevR, prevG);
}

console.log(Math.min(r, g, b));

/* 확장 가능
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const MAX_COST = 10000000;

const n = Number(input[0]);
let colors = input[1].split(" ").map(Number);

for(let i = 2; i <= n; i++) {
    const prevColors = colors;
    
    colors = input[i].split(" ").map(Number);
    for(let j = 0; j < colors.length; j++) { // 다른 색 중 최솟값 더하기
        let minPrevColor = MAX_COST;
        for(let k = 0; k < colors.length; k++)
            if(j !== k)
                minPrevColor = Math.min(minPrevColor, prevColors[k])
        colors[j] += minPrevColor;
    }
}

console.log(Math.min(...colors));
*/