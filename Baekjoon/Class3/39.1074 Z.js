const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const getZOrder = (size, row, col) => {
    if(size === 2) // 종료 조건
        return row * 2 + col;
    
    const half = size >> 1;
    // half 제곱 * 사분면 Z 위치 + 재귀 호출
    return half * half * ((row < half ? 0 : 1) * 2 + (col < half ? 0 : 1))
        + getZOrder(half, row < half ? row : row - half, col < half ? col : col - half);
}

const [n, r, c] = input.split(" ").map(Number);
console.log(getZOrder(1 << n, r, c));