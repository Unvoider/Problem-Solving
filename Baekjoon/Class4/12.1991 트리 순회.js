const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").split("\n");

const EMPTY_NODE = ".";

const tree = new Map();
const preorderOut = [];
const inorderOut = [];
const postorderOut = [];

const getOrder = (node) => {
    if(node == EMPTY_NODE) return;
    preorderOut.push(node);
    getOrder(tree.get(node)[0]);
    inorderOut.push(node);
    getOrder(tree.get(node)[1]);
    postorderOut.push(node);
};

const n = Number(input[0]);

for(let i = 1; i <= n; i++) { // 이진 트리
    const [parent, left, right] = input[i].trim().split(" ");
    tree.set(parent, [left, right]);
}

getOrder("A"); // 탐색
console.log([preorderOut.join(""), inorderOut.join(""), postorderOut.join("")].join("\n"));