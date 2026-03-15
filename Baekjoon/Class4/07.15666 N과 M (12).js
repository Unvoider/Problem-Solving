const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const [_, m] = input[0].split(" ").map(Number);
const track = [];
const nums = Array.from(
    new Set(input[1].split(" ").map(Number)) // 중복 제거
).sort((a, b) => a - b); // 정렬
const out = [];

const backTrack = (start) => {
    if(track.length === m) { // 출력
        out.push(track.join(" "));
        return;
    }
    for(let i = start; i < nums.length; i++) {
        track.push(nums[i]); // 추가
        backTrack(i);
        track.pop(); // 삭제
    }
}

backTrack(0);
console.log(out.join("\n"));