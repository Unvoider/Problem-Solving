const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const visited = new Array(n).fill(false);
const track = [];
const nums = input[1].split(" ").map(Number).sort((a, b) => a - b);
const out = [];

const backTrack = () => {
    if(track.length === m) { // 출력
        out.push(track.join(" "));
        return;
    }
    for(let i = 0; i < n; i++) {
        if(!visited[i]) {
            track.push(nums[i]); // 추가
            visited[i] = true;
            backTrack();
            track.pop(); // 삭제
            visited[i] = false;
        }
    }
}

backTrack();
console.log(out.join("\n"));