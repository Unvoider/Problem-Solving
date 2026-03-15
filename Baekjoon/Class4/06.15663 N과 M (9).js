const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const visited = new Array(n).fill(false);
const track = [];
const nums = input[1].split(" ").map(Number).sort((a, b) => a - b); // 정렬
const out = [];

const backTrack = () => {
    if(track.length === m) { // 출력
        out.push(track.join(" "));
        return;
    }
    let prevNum = -1;
    for(let i = 0; i < n; i++) {
        if(!visited[i]) {
            const curNum = nums[i]
            if(prevNum == curNum) continue; // 해당 깊이 직전 숫자와 같으면 건너뛰기
            else prevNum = curNum;
            track.push(curNum); // 추가
            visited[i] = true;
            backTrack();
            track.pop(); // 삭제
            visited[i] = false;
        }
    }
}

backTrack();
console.log(out.join("\n"));