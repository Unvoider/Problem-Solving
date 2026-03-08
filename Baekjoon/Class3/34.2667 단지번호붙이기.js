const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const MOVE_DIR = [[-1, 0], [1, 0], [0, -1], [0, 1]];
const HOUSE = "1";
const EMPTY = "0";

const n = Number(input[0]);

const houses = [];
for(let i = 1; i <= n; i++)
    houses.push(input[i].split(""));

const houseCounts = [];
for(let r = 0; r < n; r++)
    for(let c = 0; c < n; c++)
        if(houses[r][c] === HOUSE) { // 집이 있음
            let houseCount = 1;
            let bfsHead = 0; // 너비 우선 탐색
            const bfs = [[r, c]];
            houses[r][c] = EMPTY;
            while(bfsHead < bfs.length) { // 인접한 집 확인
                const [startR, startC] = bfs[bfsHead++];
                for(const [moveR, moveC] of MOVE_DIR) {
                    const endR = startR + moveR;
                    const endC = startC + moveC;
                    if(endR < 0 || endR >= n || endC < 0 || endC >= n)
                        continue;
                    if(houses[endR][endC] === HOUSE) { // 인접한 집이 있음
                        houseCount++;
                        bfs.push([endR, endC]);
                        houses[endR][endC] = EMPTY;
                    }
                }
            }
            houseCounts.push(houseCount);
        }

houseCounts.sort((a, b) => a - b); // 오름차순 정렬
console.log(`${houseCounts.length}\n${houseCounts.join("\n")}`); // 단지 수와 단지당 집 수
