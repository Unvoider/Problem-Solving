const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const MAX_NUM = 9999;
const DIGIT_LIMIT = 10000;
const BEGINNING = -1;
const SYMBOLS = "DSLR";

let cursor = 1;
const runRegister = (out) => {
    const [a, b] = input[cursor++].split(" ").map(Number);

    const operations = new Array(MAX_NUM + 1).fill(null); // [operation, prevIndex]
    let bfsHead = 0;
    const bfs = [a]; // 너비 우선 탐색
    operations[a] = ["", BEGINNING];
    while(bfsHead < bfs.length) {
        const start = bfs[bfsHead++];

        const ends = [ // DSLR 계산
            (2 * start) % DIGIT_LIMIT,
            start == 0 ? MAX_NUM : start - 1,
            (start * 10) % DIGIT_LIMIT + Math.trunc(start / (DIGIT_LIMIT / 10)), // shift left + carry
            Math.trunc((start / 10) + (start % 10) * (DIGIT_LIMIT / 10)) // shift right + carry * 1000
        ];

        for(let i = 0; i < ends.length; i++) {
            const end = ends[i];
            if(operations[end] == null) { // 연산자 저장
                bfs.push(end);
                operations[end] = [SYMBOLS[i], start];
            }
            if(end == b) { // B 도착
                const trace = []
                let cur = operations[end]; // 역추적
                while(cur[1] != BEGINNING) {
                    trace.push(cur[0]);
                    cur = operations[cur[1]];
                }
                out.push(trace.reverse().join(""));
                return;
            }
        }
    }
}

const t = Number(input[0]);
const out = [];
for(let _ = 0; _ < t; _++)
    runRegister(out)
console.log(out.join("\n"));