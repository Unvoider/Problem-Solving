const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const nums = input[1].split(" ").map(Number);
let closest = 0;
for(let i = 0; i < n - 2; i++)
    for(let j = i + 1; j < n - 1; j++)
        for(let k = j + 1; k < n; k++) {
            const total = nums[i] + nums[j] + nums[k];
            if(total <= m && total > closest) {
                closest = total;
                if(closest == m) // 같으면 바로 종료
                    i = j = k = n;
            }
        }
console.log(closest);