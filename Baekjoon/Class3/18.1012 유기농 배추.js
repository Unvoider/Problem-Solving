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
        const x = input[cursor++];
        const y = input[cursor++];
        graph[x][y] = true;
    }

    let components = 0;
    for(let x = 0; x < m; x++) {
        for(let y = 0; y < n; y++) {
            if(graph[x][y]) { // 연결 요소 시작점 찾기
                graph[x][y] = false;
                components++;

                let bfsHead = 0;
                const bfs = [[x, y]];
                while(bfsHead < bfs.length) { // 너비 우선 탐색
                const [startX, startY] = bfs[bfsHead++];
                for(const [moveX, moveY] of MOVE_DIR) {
                    const endX = startX + moveX;
                    const endY = startY + moveY;
                    if(endX >= 0 && endX < m && endY >= 0 && endY < n)
                        if(graph[endX][endY]) {
                            bfs.push([endX, endY]);
                            graph[endX][endY] = false;
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