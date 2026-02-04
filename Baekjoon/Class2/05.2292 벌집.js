const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const n = Number(input);
let lastRoom = 1, dist = 1;
while(n > lastRoom) {
    lastRoom += dist * 6; // 마지막 방 번호가 dist * 6씩 증가함
    dist++;
}
console.log(dist);