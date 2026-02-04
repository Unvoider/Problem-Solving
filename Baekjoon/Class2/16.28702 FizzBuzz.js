const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

for(let i = 0; i < 3; i++) {
    if(isNaN(input[i])) continue; // 숫자인 입력 찾기
    const value = Number(input[i]) + 3 - i; // 다음 숫자
    if(value % 15 === 0) console.log("FizzBuzz"); // 출력
    else if(value % 3 === 0) console.log("Fizz");
    else if(value % 5 === 0) console.log("Buzz");
    else console.log(value);
    break;
}