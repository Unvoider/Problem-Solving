const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const [n, k] = input[0].split(" ").map(Number);

const maxAccVals = new Array(k + 1).fill(0); // 가방 용량에 따른 모든 물건 가치 누적
for(let i = 1; i <= n; i++) {
    const [w, v] = input[i].split(" ").map(Number);
    for(let j = k; j >= w; j--) // i번째 물건이 중복 처리되는 것을 방지하기 위해 역순으로 처리
        // 해당 물건을 넣지 않았을 때의 최댓값과, 해당 물건을 넣었을 때 나머지 용량에 넣을 수 있는 최댓값 비교
        maxAccVals[j] = Math.max(maxAccVals[j], v + maxAccVals[j - w]);
}

console.log(maxAccVals[k]);