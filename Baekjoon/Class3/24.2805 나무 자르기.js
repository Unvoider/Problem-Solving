const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const isLengthEnough = (cutterHeight, required, trees) => {
    let length = 0
    for(const tree of trees)
        if(tree > cutterHeight) {
            length += tree - cutterHeight;
            if(length >= required) return true; // 충분한 길이
        }
    return false; // 충분하지 않음
}

const maxCutterHeight = (required, trees) => {
    let answer = 0;
    let left = 0, right = Math.max(...trees);
    while(left <= right) {
        const middle = Math.trunc((left + right) / 2);
        if(isLengthEnough(middle, required, trees)) { // 더 높게 자를 수도 있음
            left = middle + 1;
            answer = middle;
        }
        else // 더 낮게 잘라야 함
            right = middle - 1;
    }
    return answer;
}

const [_, m] = input[0].split(" ").map(Number);
const trees = input[1].split(" ").map(Number);
console.log(maxCutterHeight(m, trees));