const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

// 나머지 연산
const countPaint = (board, row, col) => { // 색칠해야 하는 칸 세기
    let count = 0;
    for(let i = row; i < row + 8; i++)
        for(let j = col; j < col + 8; j++)
            if((i + j) % 2 === 0 && board[i][j] === "B") // 잘못 색칠된 검정
                count++;
            else if((i + j) % 2 === 1 && board[i][j] === "W") // 잘못 색칠된 하양
                count++;
    return count;
}

/* 체스판 생성
const countPaint = (board, row, col) => { // 색칠해야 하는 칸 세기
    let rowFirst = "W" // 흰색으로 시작하는 체스 보드
    let count = 0;
    for(let i = 0; i < 8; i++) {
        cur = rowFirst;
        for(let j = 0; j <  8; j++) {
            if(board[i + row][j + col] != cur)
                count++;
            cur = (cur == 'W') ? 'B' : 'W';
        }
        rowFirst = (rowFirst == 'W') ? 'B' : 'W';
    }
    return count;
}
*/

/* 체스판 정의
const CHESS_BOARD = [ // 흰색으로 시작하는 체스 보드
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW"
]
const countPaint = (board, row, col) => { // 색칠해야 하는 칸 세기
    let count = 0;
    for(let i = 0; i < 8; i++)
        for(let j = 0; j <  8; j++)
            if(board[i + row][j + col] != CHESS_BOARD[i][j])
                count++;
    return count;
}
*/

const [n, m] = input[0].split(" ").map(Number);
const board = input.slice(1);

let minCount = 64;
for(let row = 0; row <= n - 8; row++)
    for(let col = 0; col <= m - 8; col++) {
        let count = countPaint(board, row, col);
        // 흰색으로 시작할 때 색칠할 칸, 반전한 경우, 이전 최소값 중 최소값 선택
        minCount = Math.min(count, 64 - count, minCount);
    }
console.log(minCount);