const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const n = Number(input[0]);
const nums = [];
const out = [];

let total = 0;
for(let i = 1; i <= n; i++) {
    const num = Number(input[i]);
    nums.push(num);
    total += num; // 합계
}

nums.sort((a, b) => a - b); // 정렬

// 두 번째로 작은 최빈값 찾기
let prev = nums[0], mode = nums[0], freq = 1, maxFreq = 1, modeCount = 1;
for(let i = 1; i < n; i++) {
    // 빈도 계산
    if(prev == nums[i])
        freq++;
    else
        freq = 1;

    // 최대 빈도 찾기
    if(freq == maxFreq) { // 최대 빈도와 같은 빈도
        if(modeCount < 2) { // 두 번째까지 업데이트
            modeCount++;
            mode = nums[i];
        }
    }
    else if(freq > maxFreq) { // 최대 빈도보다 높은 빈도
        modeCount = 1;
        maxFreq = freq;
        mode = nums[i];
    }

    prev = nums[i];
}

out.push(Math.round(total / n)); // 산술평균
out.push(nums[Math.trunc(n / 2)]); // 중앙값
out.push(mode); // 최빈값
out.push(nums[n - 1] - nums[0]); // 범위
console.log(out.join("\n"));