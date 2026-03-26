const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const [n, k] = input.split(" ").map(Number);
const depthLimit = Math.max(n, k) * 2;

const bfs = [n]; // 0-1 너비 우선 탐색
const depths = new Array(depthLimit + 1).fill(-1);
depths[n] = 0; // 시작

while(bfs.length !== 0) {
    const start = bfs.pop();
    if(start === k) break;

    const teleport = start * 2;
    if(teleport <= depthLimit && depths[teleport] === -1) { // 순간 이동
        bfs.push(teleport);
        depths[teleport] = depths[start];
    }

    for(const walk of [start - 1, start + 1]) // 걷기
        if(walk >= 0 && walk <= depthLimit && depths[walk] === -1) {
            bfs.unshift(walk);
            depths[walk] = depths[start] + 1;
        }
}

console.log(depths[k]);