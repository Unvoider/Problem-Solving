const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const nSet = new Set(input[1].split(" ").map(Number));
const mArr = input[3].split(" ").map(Number);
const out = [];

for(const mNum of mArr) {
    // Set는 해시 테이블을 사용하므로 has()에 대해 O(1)
    if(nSet.has(mNum))
        out.push("1");
    else
        out.push("0");
}
console.log(out.join("\n"));

/* 이진 탐색 구현
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const binSearch = (arr, target) => {
    let left = 0, right = arr.length - 1;
    while (left <= right) {
        let middle = Math.trunc((left + right) / 2);
        switch(Math.sign(arr[middle] - target)) {
            case 0: return middle;
            case -1: left = middle + 1;
                break;
            case 1: right = middle - 1;
        }
    }
    return -1;
}

const nArr = input[1].split(" ").map(Number).sort((a, b) => a - b); // 정렬
const mArr = input[3].split(" ").map(Number);
const out = [];

for(const mNum of mArr) {
    // 이진 탐색 O(logn)
    if(binSearch(nArr, mNum) > -1)
        out.push("1");
    else
        out.push("0");
}
console.log(out.join("\n"));
*/