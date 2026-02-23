const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);
const paper = new Array();
for(let i = 1; i <= n; i++)
    paper.push(input[i].split(" ").map(Number));

const isUniform = (x, y, size) => {
    const first = paper[x][y];
    for(let i = x; i < x + size; i++)
        for(let j = y; j < y + size; j++)
            if(first !== paper[i][j])
                return false;
    return true;
}

const cutPapers = (x, y, size) => { // return [white, blue]
    if(isUniform(x, y, size)) // 모두 같은 색일 때 종료
        return paper[x][y] === 0 ? [1, 0] : [0, 1];

    const half = size >> 1; // 사등분
    let white = 0, blue = 0;
    for(let i = 0; i < 2; i++)
        for(let j = 0; j < 2; j++) {
            const [w, b] = cutPapers(x + i * half, y + j * half, half);
            white += w;
            blue += b;
        }
    return [white, blue];
}

const counts = cutPapers(0, 0, n);
console.log(counts.join("\n"));