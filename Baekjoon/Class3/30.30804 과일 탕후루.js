const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);
const sn = input[1].split(" ").map(Number); // 과일 순서

let maxFruit = 0;
let fruitTypes = 0; // 과일 종류
const fruitCounts = new Array(10).fill(0); // 과일 종류별 개수

let front = 0, rear = 0;
while(rear < n) {
    const rearFruit = sn[rear++]; // 과일 추가
    if(fruitCounts[rearFruit]++ === 0)
        fruitTypes++;
    while(fruitTypes > 2) { // 두 종류보다 많으면 과일 제거
        const frontFruit = sn[front++];
        if(--fruitCounts[frontFruit] === 0)
            fruitTypes--;
    }
    maxFruit = Math.max(maxFruit, rear - front); // 최대 개수 업데이트
}
console.log(maxFruit);