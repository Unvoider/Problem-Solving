const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const EMPTY = 0;

/*
가로 도착
000 000
000 000
pp0 0pp

000 000
p00 000
0p0 0pp

세로 도착
00p 000
00p 00p
000 00p

0p0 000
00p 00p
000 00p

대각선 도착
000 000
pp0 0p0
000 00p

0p0 000
0p0 0p0
000 00p

p00 000
0p0 0p0
000 00p
*/

const n = Number(input[0]);

// 벽 위치 기록
const walls = Array.from({ length: n + 1 }, () => new Array(n + 1).fill(0));
for(let r = 1; r <= n; r++) {
    const row = input[r].split(" ").map(Number);
    for(let c = 1; c <= n; c++)
        walls[r][c] = row[c - 1];
}

// [행][열][파이프 방향(가로: 0, 세로: 1, 대각선: 2)]
const moves = Array.from({ length: n + 1 }, () => Array.from({ length: n + 1 }, () => new Array(3).fill(0)));
moves[1][2][0] = 1;

for(let c = 3; c <= n; c++) // 첫 줄
    if(walls[1][c] === EMPTY)
        moves[1][c][0] = moves[1][c - 1][0]; // 가로 도착

for(let r = 2; r <= n; r++)
    for(let c = 2; c <= n; c++)
        if(walls[r][c] === EMPTY) {
            moves[r][c][0] = moves[r][c - 1][0] + moves[r][c - 1][2]; // 가로 도착
            moves[r][c][1] = moves[r - 1][c][1] + moves[r - 1][c][2]; // 세로 도착
            if(walls[r - 1][c] === EMPTY && walls[r][c - 1] === EMPTY) // 대각선 도착
                moves[r][c][2] = moves[r - 1][c - 1][0] + moves[r - 1][c - 1][1] + moves[r - 1][c - 1][2];
        }

console.log(moves[n][n][0] + moves[n][n][1] + moves[n][n][2]);