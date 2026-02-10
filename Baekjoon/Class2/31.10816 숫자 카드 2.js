// Map 사용
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const cards = input[1].split(" ").map(Number);
const targets = input[3].split(" ").map(Number);
const counts = new Map();
const out = [];

for(const card of cards)
    counts.set(card, (counts.get(card) || 0) + 1);
for(const target of targets)
    // Map의 접근 시간 O(1)
    out.push(counts.get(target) || 0);

console.log(out.join(" "));

/* 이진 탐색 구현
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const binSearchLowerBound = (arr, target) => {
    let lowerBound = -1;
    let left = 0, right = arr.length - 1;
    while(left <= right) {
        const middle = Math.floor((left + right) / 2);
        if(arr[middle] >= target) {
            if(arr[middle] === target) // 찾음
                lowerBound = middle;
            right = middle - 1; // 찾았어도 왼쪽 범위 계속 확인
        }
        else
            left = middle + 1;
    }
    return lowerBound;
}

const binSearchUpperBound = (arr, target) => {
    let upperBound = -1;
    let left = 0, right = arr.length - 1;
    while(left <= right) {
        const middle = Math.floor((left + right) / 2);
        if(arr[middle] <= target) {
            if(arr[middle] === target) // 찾음
                upperBound = middle + 1;
            left = middle + 1; // 찾았어도 오른쪽 범위 계속 확인
        }
        else
            right = middle - 1;
    }
    return upperBound;
}

const cards = input[1].split(" ").map(Number).sort((a, b) => a - b); // 정렬
const targets = input[3].split(" ").map(Number);
const out = [];

for(const target of targets) {
    const targetLB = binSearchLowerBound(cards, target);
    if(targetLB === -1) { // 시작 인덱스 없음
        out.push("0");
        continue;
    }
    const targetUB = binSearchUpperBound(cards, target);
    out.push(targetUB - targetLB);
}

console.log(out.join(" "));
*/