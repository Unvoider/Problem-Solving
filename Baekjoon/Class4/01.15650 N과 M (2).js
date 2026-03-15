const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const [n, m] = input.split(" ").map(Number);
const visited = new Array(n + 1).fill(false);
const track = [];
const out = [];

const backTrack = (start) => {
    if(track.length === m) { // 출력
        out.push(track.join(" "));
        return;
    }
    for(let i = start; i <= n; i++) {
        if(!visited[i]) {
            track.push(i); // 추가
            visited[i] = true;
            backTrack(i + 1);
            track.pop(); // 삭제
            visited[i] = false;
        }
    }
}

backTrack(1);
console.log(out.join("\n"));