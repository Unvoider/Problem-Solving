const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const out = [];

const passwords = new Map(); // {site: password}
for(let i = 1; i <= n; i++) { // 비밀번호 입력
    const [site, password] = input[i].split(" ");
    passwords.set(site, password);
}
for(let i = n + 1; i <= n + m; i++) { // 비밀번호 출력
    const site = input[i].trim();
    out.push(passwords.get(site));
}
console.log(out.join("\n"));