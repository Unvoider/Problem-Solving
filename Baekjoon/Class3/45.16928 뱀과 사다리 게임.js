const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const BOARD_SIZE = 100;

const countRolls = (laddersAndSnakes) => {
    const rollCounts = new Array(BOARD_SIZE + 1).fill(0); // 암시적 그래프
    let bfsHead = 0;
    const bfs = [1]; // 시작 위치
    while(bfsHead < bfs.length) {
        const start = bfs[bfsHead++];
        for(let move = 1; move <= 6; move++) {
            let end = start + move;
            if(end < BOARD_SIZE && laddersAndSnakes[end] !== 0) // 사다리 뱀 타기
                end = laddersAndSnakes[end];
            if(end <= 0 || end > BOARD_SIZE) // 경계 검사
                continue;
            if(rollCounts[end] === 0) { // 이동
                rollCounts[end] = rollCounts[start] + 1;
                if (end === 100)
                    return rollCounts[end];
                bfs.push(end);
            }
        }
    }
}

const [n, m] = input[0].split(" ").map(Number);

const laddersAndSnakes = new Array(BOARD_SIZE).fill(0);
for(let i = 1; i <= n + m; i++) {
    const [start, end] = input[i].split(" ").map(Number);
    laddersAndSnakes[start] = end;
}

console.log(countRolls(laddersAndSnakes));