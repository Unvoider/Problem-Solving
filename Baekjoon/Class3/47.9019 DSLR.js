// 양방향 BFS
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const MAX_NUM = 9999;
const DIGIT_LIMIT = 10000;
const BEGINNING = -1;
const A_OPERATIONS = "DSLR";
const B_OPERATIONS = "DDSLR";

// 미리 DSLR 계산
const A_DSLR = Array.from({ length : MAX_NUM + 1 }, (_, n) => [
    (2 * n) % DIGIT_LIMIT,
    n == 0 ? MAX_NUM : n - 1,
    (n * 10) % DIGIT_LIMIT + Math.trunc(n / (DIGIT_LIMIT / 10)), // shift left + carry
    Math.trunc((n / 10) + (n % 10) * (DIGIT_LIMIT / 10)) // shift right + carry * 1000
]);
const B_DSLR = Array.from({ length : MAX_NUM + 1 }, (_, n) => [
    Math.trunc(n / 2),
    Math.trunc((n + DIGIT_LIMIT) / 2),
    n == MAX_NUM ? 0 : n + 1,
    Math.trunc((n / 10) + (n % 10) * (DIGIT_LIMIT / 10)), // shift right + carry * 1000
    (n * 10) % DIGIT_LIMIT + Math.trunc(n / (DIGIT_LIMIT / 10)) // shift left + carry
]);

const getTraces = (meetingPoint, aOperations, bOperations) => {
    const trace = []
    let cur = aOperations[meetingPoint]; // A 역추적
    while(cur[1] !== BEGINNING) {
        trace.push(cur[0]);
        cur = aOperations[cur[1]];
    }
    trace.reverse();
    
    cur = bOperations[meetingPoint]; // B 역추적
    while(cur[1] !== BEGINNING) {
        trace.push(cur[0]);
        cur = bOperations[cur[1]];
    }
    return trace.join("");
}

let cursor = 1;
const runRegister = (out) => {
    const [a, b] = input[cursor++].split(" ").map(Number);
    if(a === b) {
        out.push("");
        return;
    }

    const aOperations = new Array(MAX_NUM + 1).fill(null); // [operation, prevIndex]
    const bOperations = new Array(MAX_NUM + 1).fill(null);
    let aBfsHead = 0;
    let bBfsHead = 0;
    const aBfs = [a]; // 너비 우선 탐색
    const bBfs = [b];
    aOperations[a] = ["", BEGINNING];
    bOperations[b] = ["", BEGINNING];

    while(true) {
        let levelLimit = aBfs.length;
        while(aBfsHead < levelLimit) { // 한 레벨씩
            const start = aBfs[aBfsHead++];

            // 정방향 탐색
            for(let i = 0; i < 4; i++) {
                const end = A_DSLR[start][i];
                if(aOperations[end] === null) { // 연산자 저장
                    aBfs.push(end);
                    aOperations[end] = [A_OPERATIONS[i], start];
                }
                if(bOperations[end] !== null) { // 반대편과 만남
                    out.push(getTraces(end, aOperations, bOperations));
                    return;
                }
            }
        }

        levelLimit = bBfs.length;
        while(bBfsHead < levelLimit) {
            const start = bBfs[bBfsHead++];

            // 정방향 탐색
            for(let i = (start % 2 === 0) ? 0 : 2; i < 5; i++) {
                const end = B_DSLR[start][i];
                if(bOperations[end] === null) { // 연산자 저장
                    bBfs.push(end);
                    bOperations[end] = [B_OPERATIONS[i], start];
                }
                if(aOperations[end] !== null) { // 반대편과 만남
                    out.push(getTraces(end, aOperations, bOperations));
                    return;
                }
            }
        }
    }
}

const t = Number(input[0]);
const out = [];
for(let _ = 0; _ < t; _++)
    runRegister(out)
console.log(out.join("\n"));

/* 단방향 BFS
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const MAX_NUM = 9999;
const DIGIT_LIMIT = 10000;
const BEGINNING = -1;
const OPERATIONS = "DSLR";

let cursor = 1;
const runRegister = (out) => {
    const [a, b] = input[cursor++].split(" ").map(Number);

    const operations = new Array(MAX_NUM + 1).fill(null); // [operation, prevIndex]
    let bfsHead = 0;
    const bfs = [a]; // 너비 우선 탐색
    operations[a] = ["", BEGINNING];
    while(true) {
        const start = bfs[bfsHead++];

        const ends = [ // DSLR 계산
            (2 * start) % DIGIT_LIMIT,
            start === 0 ? MAX_NUM : start - 1,
            (start * 10) % DIGIT_LIMIT + Math.trunc(start / (DIGIT_LIMIT / 10)), // shift left + carry
            Math.trunc((start / 10) + (start % 10) * (DIGIT_LIMIT / 10)) // shift right + carry * 1000
        ];

        for(let i = 0; i < ends.length; i++) {
            const end = ends[i];
            if(operations[end] === null) { // 연산자 저장
                bfs.push(end);
                operations[end] = [OPERATIONS[i], start];
            }
            if(end === b) { // B 도착
                const trace = []
                let cur = operations[end]; // 역추적
                while(cur[1] !== BEGINNING) {
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
*/