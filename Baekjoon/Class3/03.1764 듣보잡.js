const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);

const unheard = new Set() // 듣도 못한 사람
for(let i = 1; i <= n; i++)
    unheard.add(input[i]);

const unheardUnseen = [] // 듣도 보도 못한 사람
for(let i = n + 1; i <= n + m; i++) {
    const name = input[i];
    if(unheard.has(name))
        unheardUnseen.push(name);
}

unheardUnseen.sort(); // 정렬
console.log(`${unheardUnseen.length}\n${unheardUnseen.join("\n")}`);