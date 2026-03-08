const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/).map(Number);

const MOVE_DIR = [[-1, 0], [1, 0], [0, -1], [0, 1]]

let cursor = 1;
const countWorms = (out) => {
    const m = input[cursor++];
    const n = input[cursor++];
    const k = input[cursor++];
    
    const graph = Array.from({ length: m }, () => new Array(n).fill(false)); // 격자 그래프
    for(let _ = 0; _ < k; _++) {
        const r = input[cursor++];
        const c = input[cursor++];
        graph[r][c] = true;
    }

    let components = 0;
    for(let r = 0; r < m; r++) {
        for(let c = 0; c < n; c++) {
            if(graph[r][c]) { // 연결 요소 시작점 찾기
                graph[r][c] = false;
                components++;

                let bfsHead = 0;
                const bfs = [[r, c]];
                while(bfsHead < bfs.length) { // 너비 우선 탐색
                    const [startR, startC] = bfs[bfsHead++];
                    for(const [moveR, moveC] of MOVE_DIR) {
                        const endR = startR + moveR;
                        const endC = startC + moveC;
                        if(endR < 0 || endR >= m || endC < 0 || endC >= n)
                            continue;
                        if(graph[endR][endC]) {
                            bfs.push([endR, endC]);
                            graph[endR][endC] = false;
                        }
                    }
                }
            }
        }
    }
    out.push(components); // 연결 요소 수
}

const t = Number(input[0]);
const out = [];
for(let _ = 0; _ < t; _++)
    countWorms(out);
console.log(out.join("\n"));