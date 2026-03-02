const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim();

const MAX_POS = 100000

class HideAndSeek {
    #seekTime;
    constructor(seeker, hider) {
        const depths = new Array(MAX_POS + 1).fill(-1);
        let bfsHead = 0;
        const bfs = [seeker]; // 너비 우선 탐색
        depths[seeker] = 0;
        while(true) {
            const start = bfs[bfsHead++];
            if(start === hider) // 찾음
                break;
            const ends = [start - 1, start + 1, start * 2]; // 못 찾음
            for (const end of ends) {
                if(end >= 0 && end <= MAX_POS && depths[end] === -1) {
                    bfs.push(end);
                    depths[end] = depths[start] + 1;
                }
            }
        }
        this.#seekTime = depths[hider];
    }
    
    get seekTime() {
        return this.#seekTime;
    }
}

const [n, k] = input.split(" ").map(Number);
console.log(new HideAndSeek(n, k).seekTime);