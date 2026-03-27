const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const MAX_DIST = 1000000000;

const [n, m] = input[0].split(" ").map(Number); // 행렬 크기, 폐업시키지 않을 치킨 집 수

const houses = [], chickens = [];
for(let r = 0; r < n; r++) {
    const row = input[r + 1].trim().split(" ");
    for(let c = 0; c < n; c++) // 집과 치킨집의 위치 저장
        if(row[c] === "1")
            houses.push([r, c]);
        else if(row[c] === "2")
            chickens.push([r, c]);
}

// 타뷸레이션
const chickenDists = Array.from({ length: houses.length }, () => new Array(chickens.length).fill(0));
for(let i = 0; i < houses.length; i++) // 각 집과 치킨집의 최소 거리 구하기
    for(let j = 0; j < chickens.length; j++)
        chickenDists[i][j] = Math.abs(chickens[j][0] - houses[i][0]) + Math.abs(chickens[j][1] - houses[i][1]);

const isOpen = new Array(chickens.length).fill(false);
let chickenDist = MAX_DIST;

const chooseChickens = (cur, count) => {
    if(count === m) { // m개 선택됨
        let totalMinDist = 0;
        for(let i = 0; i < houses.length; i++) { // 각 집과 열린 치킨집의 최소 거리 누적
            let minDist = MAX_DIST;
            for(let j = 0; j < chickens.length; j++)
                if(isOpen[j])
                    minDist = Math.min(minDist, chickenDists[i][j]);
            totalMinDist += minDist;
        }
        chickenDist = Math.min(chickenDist, totalMinDist); // 최소 거리 업데이트
        return;
    }

    for(let i = cur; i < chickens.length; i++) { // 모든 조합 확인
        isOpen[i] = true;
        chooseChickens(i + 1, count + 1);
        isOpen[i] = false; // 백트래킹
    }
}

chooseChickens(0, 0);
console.log(chickenDist);