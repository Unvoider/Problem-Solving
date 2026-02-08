// 반복 동적 프로그래밍
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n").map(Number);

let cursor = 0;
const t = input[cursor++];
const apt = Array.from({ length: 15 }, () => new Array(15)); // 타뷸레이션
const out = [];

for(let i = 0; i < 15; i++) {
    apt[0][i] = i + 1; // 0층 초기화
    apt[i][0] = 1; // 1호 초기화
}
for(let i = 1; i < 15; i++) // 전체 계산
    for (let j = 1; j < 15; j++)
        apt[i][j] = apt[i - 1][j] + apt[i][j - 1]; // 아랫집 + 왼쪽 집

for(let _ = 0; _ < t; _++) {
    const k = input[cursor++];
    const n = input[cursor++];
    out.push(apt[k][n - 1]);
}
console.log(out.join("\n"));

/* 재귀 동적 프로그래밍
const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n").map(Number);

const apt = Array.from({ length: 15 }, () => new Array(15)); // 메모이제이션
for(let i = 0; i < 15; i++) {
    apt[0][i] = i + 1; // 0층 초기화
    apt[i][0] = 1; // 1호 초기화
}

const countPeople = (floor, room) => {
    // 0층/1호 고정 값
    if(floor == 0) return room;
    if(room == 1) return 1;

    // 저장된 값 반환
    let count = apt[floor][room];
    if(count) return count;

    // 없으면 계산
    count = countPeople(floor - 1, room) + countPeople(floor, room - 1);
    apt[floor][room] = count;
    return count;
}

let cursor = 0;
const t = input[cursor++];
const out = [];

for(let _ = 0; _ < t; _++) {
    const k = input[cursor++];
    const n = input[cursor++];
    out.push(countPeople(k, n));
}
console.log(out.join("\n"));
*/