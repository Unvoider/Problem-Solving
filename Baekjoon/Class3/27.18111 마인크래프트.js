const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

HEIGHT_LIMIT = 256;

const [n, _, b] = input[0].split(" ").map(Number);

let minH = HEIGHT_LIMIT, maxH = 0;
const heightCounts = new Array(HEIGHT_LIMIT + 1).fill(0);
for(let i = 1; i <= n; i++)
    for(const h of input[i].split(" ").map(Number)) {
        if(minH > h) minH = h;
        if(maxH < h) maxH = h;
        heightCounts[h]++;
    }

let minTime = Infinity, flatH = 0;
for(let targetH = minH; targetH <= maxH; targetH++) { // 모든 높이 확인
    let toPlace = 0, toBreak = 0; // 해당 높이에서 설치/삭제해야 하는 블록 수
    for(let curH = minH; curH <= maxH; curH++) {
        const blocks = targetH - curH;
        if(blocks > 0)
            toPlace += blocks * heightCounts[curH];
        else if(blocks < 0)
            toBreak -= blocks * heightCounts[curH];
    }
    if(b + toBreak >= toPlace) { // 인벤토리 블록 수 확인
        const time = toBreak * 2 + toPlace;
        if(minTime >= time) { // 최소 시간 갱신
            minTime = time;
            flatH = targetH;
        }
    }
}

console.log(`${minTime} ${flatH}`);