const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);
const paper = new Array();
for(let i = 1; i <= n; i++)
    paper.push(input[i].split(" ").map(Number));

const isUniform = (r, c, size) => {
    const first = paper[r][c];
    for(let i = r; i < r + size; i++)
        for(let j = c; j < c + size; j++)
            if(first !== paper[i][j])
                return false;
    return true;
}

const cutPapers = (r, c, size) => { // return [white, blue]
    if(isUniform(r, c, size)) // 모두 같은 색일 때 종료
        return paper[r][c] === 0 ? [1, 0] : [0, 1];

    const half = size >> 1; // 사등분
    let white = 0, blue = 0;
    for(let i = 0; i < 2; i++)
        for(let j = 0; j < 2; j++) {
            const [w, b] = cutPapers(r + i * half, c + j * half, half);
            white += w;
            blue += b;
        }
    return [white, blue];
}

const counts = cutPapers(0, 0, n);
console.log(counts.join("\n"));