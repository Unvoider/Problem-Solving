const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

// page, row, column
const MOVE_DIR = [[-1, 0, 0], [1, 0, 0], [0, -1, 0], [0, 1, 0], [0, 0, -1], [0, 0, 1]];
const NO_TOMATO = -1;
const UNRIPE_TOMATO = -2;

const [m, n, h] = input[0].split(" ").map(Number);

let unripeTomatoCount = 0;
let ripeTime = 0;
const depths = Array.from({ length : h }, () => Array.from({ length : n }, () => new Array(m).fill(NO_TOMATO))); // 격자 그래프
let bfsHead = 0;
const bfs = [];
let cursor = 1;
for(let p = 0; p < h; p++)
    for(let r = 0; r < n; r++) {
        const tomatoes = input[cursor++].split(" ").map(Number);
        for(let c = 0; c < m; c++) {
            const tomato = tomatoes[c];
            if(tomato === 1) { // 익음
                bfs.push([p, r, c]);
                depths[p][r][c] = 0;
            }
            else if(tomato === 0) { // 익지 않음
                depths[p][r][c] = UNRIPE_TOMATO;
                unripeTomatoCount++;
            }
        }
    }

while(bfsHead < bfs.length) { // 너비 우선 탐색
    const [startP, startR, startC] = bfs[bfsHead++];
    for(const [moveP, moveR, moveC] of MOVE_DIR) {
        const endP = startP + moveP;
        const endR = startR + moveR;
        const endC = startC + moveC;
        if(endP < 0 || endP >= h || endR < 0 || endR >= n || endC < 0 || endC >= m)
            continue;
        if(depths[endP][endR][endC] === UNRIPE_TOMATO) { // 인접 토마토가 익지 않음
            bfs.push([endP, endR, endC]); // 익히기
            ripeTime = depths[endP][endR][endC] = depths[startP][startR][startC] + 1;
            unripeTomatoCount--;
        }
    }
}

if(unripeTomatoCount === 0)
    console.log(ripeTime);
else
    console.log(-1);