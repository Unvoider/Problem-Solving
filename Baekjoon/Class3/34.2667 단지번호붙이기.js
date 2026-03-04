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
for(let x = 0; x < n; x++)
    for(let y = 0; y < n; y++)
        if(houses[x][y] === HOUSE) { // 집이 있음
            let houseCount = 1;
            let bfsHead = 0; // 너비 우선 탐색
            const bfs = [[x, y]];
            houses[x][y] = EMPTY;
            while(bfsHead < bfs.length) { // 인접한 집 확인
                const [startX, startY] = bfs[bfsHead++];
                for(const [moveX, moveY] of MOVE_DIR) {
                    const endX = startX + moveX;
                    const endY = startY + moveY;
                    if(endX < 0 || endX >= n || endY < 0 || endY >= n)
                        continue;
                    if(houses[endX][endY] === HOUSE) { // 인접한 집이 있음
                        houseCount++;
                        bfs.push([endX, endY]);
                        houses[endX][endY] = EMPTY;
                    }
                }
            }
            houseCounts.push(houseCount);
        }

houseCounts.sort((a, b) => a - b); // 오름차순 정렬
console.log(`${houseCounts.length}\n${houseCounts.join("\n")}`); // 단지 수와 단지당 집 수
