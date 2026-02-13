const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

let cursor = 1;
const runPrinter = (out) => {
    const m = Number(input[cursor++].split(" ")[1]);
    const priorities = input[cursor++].split(" ").map(Number); // 우선순위
    const printerQueue = priorities.map((val, i) => ({idx: i, priority: val})); // {인덱스, 우선순위}
    priorities.sort((a, b) => b - a); // 우선순위 내림차순 정렬
    
    // 우선순위가 높은 것부터 출력
    let order = 0; // 출력 순서
    while(true) {
        const frontDoc = printerQueue.shift();
        if(frontDoc.priority === priorities[order]) { // 해당 우선순위 찾음
            if(frontDoc.idx === m) { // 출력
                out.push(order + 1);
                break;
            }
            order++;
        }
        else // 해당 우선순위 못 찾음
            printerQueue.push(frontDoc) // 회전
    }
}

const testCase = Number(input[0]);
const out = [];

for(let _ = 0; _ < testCase; _++)
    runPrinter(out);
console.log(out.join("\n"));