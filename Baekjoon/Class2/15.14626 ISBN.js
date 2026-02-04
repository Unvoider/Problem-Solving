const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8");

const isbn = input.trim();
let damagedIdx, m, total = 0, weight = 1;

// total = (a+c+e+g+i+k) + 3(b+d+f+h+j+l)
for(let i = 0; i < 13; i++) {
    if(isbn[i] === '*') // 손상 인덱스
        damagedIdx = i;
    else {
        const value = isbn[i] - '0';
        if(i === 12) // m 값
            m = value;
        else // 0~11번째 값 누적
            total += i % 2 === 0 ? value : 3 * value;
    }
}

// m = (10 - total % 10) % 10
if(damagedIdx === 12) { // m 손상 시 바로 출력
    console.log((10 - total % 10) % 10);
}
else {
    if(damagedIdx % 2 === 1) // 홀수 번째 가중치
        weight = 3;
    for(let i = 0; i <= 9; i++) { // 0~9 넣어보고 맞으면 출력
        if(m === (10 - (total + i * weight) % 10) % 10) {
            console.log(i);
            break;
        }
    }
}