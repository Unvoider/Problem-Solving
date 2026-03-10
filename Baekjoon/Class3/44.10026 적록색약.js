const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

MOVE_DIR = [[-1, 0], [1, 0], [0, -1], [0, 1]]

class CountColorArea {
    #areaCount = 0;
    constructor(colors, isEqual) {
        const n = colors.length;
        const visited = Array.from({ length : n }, () => new Array(n).fill(false));
        for(let r = 0; r < n; r++)
            for(let c = 0; c < n; c++)
                if(!visited[r][c]) { // 처음 발견한 색
                    const current_color = colors[r][c];
                    this.#areaCount++; // 개수 세기
                    let bfsHead = 0; // 너비 우선 탐색
                    const bfs = [[r, c]];
                    visited[r][c] = true;
                    while(bfsHead < bfs.length) {
                        const [startR, startC] = bfs[bfsHead++];
                        for(const [moveR, moveC] of MOVE_DIR) {
                            const endR = startR + moveR;
                            const endC = startC + moveC;
                            if (endR < 0 || endR >= n || endC < 0 || endC >= n)
                                continue;
                            // 주변 같은 색 발견
                            if (!visited[endR][endC] && isEqual(current_color, colors[endR][endC])) {
                                bfs.push([endR, endC]);
                                visited[endR][endC] = true;
                            }
                        }
                    }
                }
    }
    get areaCount() {
        return this.#areaCount;
    }
}

const n = Number(input[0]);

const colors = [] // 격자 그래프
for(let i = 1; i <= n; i++)
    colors.push(input[i]);

const out = [
    new CountColorArea(colors, (color1, color2) => { // 일반 비교 함수
        return color1 === color2;
    }).areaCount,
    new CountColorArea(colors, (color1, color2) => { // 색맹 비교 함수
        return color1 === color2
        || color1 === "R" && color2 === "G"
        || color1 === "G" && color2 === "R";
    }).areaCount
]
console.log(out.join(" "));