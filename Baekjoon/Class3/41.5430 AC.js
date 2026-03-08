const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

let cursor = 1;
const ac = (out) => {
    const p = input[cursor].trim();
    const n = Number(input[cursor + 1]);
    const xn = n === 0 ? [] : input[cursor + 2].trim().slice(1, -1).split(","); // 파싱
    cursor += 3;

    let isFront = true; // 포인터 위치
    let front = 0;
    let rear = n - 1;
    for(const command of p)
        if(command === "R") // 덱 뒤집기
            isFront = !isFront;
        else { // 팝
            if(front > rear) { // 비었음
                out.push("error");
                return;
            }
            if(isFront)
                front++;
            else
                rear--;
        }
    
    const result = [];
    if(front <= rear) { // 출력
        if(isFront)
            for(let i = front; i <= rear; i++)
                result.push(xn[i]);
        else
            for(let i = rear; i >= front; i--)
                result.push(xn[i]);
    }
    out.push(`[${result.join(",")}]`);
}

const t = Number(input[0]);
const out = [];
for(let _ = 0; _ < t; _++)
    ac(out);
console.log(out.join("\n"));