const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const MOVE_DIR = [[-1, 0], [1, 0], [0, -1], [0, 1]];

const [n, m] = input[0].split(" ").map(Number);
const scores = Array.from({ length : n }, (_, i) => input[i + 1].split(" ").map(Number));
const visited = Array.from({ length : n }, () => new Array(m).fill(false));
const maxScore = Math.max(...scores.flat());
let maxTotal = 0

const searchMaxTotal = (startR, startC, total, depth) => {
    if(total + maxScore * (4 - depth) <= maxTotal) // 아무리 더해도 새 최댓값이 될 수 없음
        return;

    if(depth === 4) { // 깊이가 4일 때까지 모든 테트로미노 찾기
        if(total > maxTotal) maxTotal = total;
        return;
    }
    for(const [moveR, moveC] of MOVE_DIR) {
        const endR = startR + moveR;
        const endC = startC + moveC;
        if(endR < 0 || endR >= n || endC < 0 || endC >= m)
            continue;
        if(!visited[endR][endC]) {
            if(depth === 2) { // 깊이가 2면 ㅜ 모양 테트로미노 찾기
                visited[endR][endC] = true;
                searchMaxTotal(startR, startC, total + scores[endR][endC], depth + 1);
                visited[endR][endC] = false;
            }
            visited[endR][endC] = true;
            searchMaxTotal(endR, endC, total + scores[endR][endC], depth + 1);
            visited[endR][endC] = false;
        }
    }
}

for(let r = 0; r < n; r++)
    for(let c = 0; c < m; c++) {
        visited[r][c] = true;
        searchMaxTotal(r, c, 0, 0);
        visited[r][c] = false;
    }
console.log(maxTotal);