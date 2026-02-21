const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split(/\s+/).map(Number);

const countCutWire = (length, wires) => { // 잘린 선 개수
    return wires.reduce((acc, wire) => acc + Math.trunc(wire / length), 0);
}

const maxCutLength = (required, wires) => {
    let answer = 0;
    let left = 1, right = Math.max(...wires);
    while(left <= right) {
        const middle = Math.trunc((left + right) / 2);
        if(countCutWire(middle, wires) >= required) { // 더 길게 자를 수도 있음
            left = middle + 1;
            answer = middle;
        }
        else // 더 짧게 잘라야 함
            right = middle - 1;
    }
    return answer;
}

const [_, n, ...wires] = input;
console.log(maxCutLength(n, wires));