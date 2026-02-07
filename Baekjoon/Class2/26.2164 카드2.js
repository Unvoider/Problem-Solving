const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const n = Number(input);
const cards = Array.from({ length: n }, (_, i) => i + 1); // queue full 기능이 없는 원형 큐
let front = 0; // full ascending
let rear = 0; // empty ascending
const forward = (idx) => (idx + 1) % n;

let next;
while((next = forward(front)) !== rear) { // 1개 남으면 종료
    front = next; // 맨 위 제거
    cards[rear] = cards[front]; // 맨 위 -> 맨 아래
    front = forward(front);
    rear = forward(rear);
}
console.log(cards[front]);