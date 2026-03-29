const inputFile = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require("fs").readFileSync(inputFile, "utf8").trim().split("\n");

const [n, m] = input[0].split(" ").map(Number); // 사람 수, 파티 수
const knows = new Array(n + 1).fill(false);
const parents = Array.from({ length: n + 1 }, (_, i) => i); // 루트는 자기 자신을 부모로

const knowingPeople = input[1].split(" ").map(Number);
for(let i = 1; i <= knowingPeople[0]; i++) // 아는 사람 설정
    knows[knowingPeople[i]] = true;

const collapsingFind = (node) => {
    if(parents[node] === node) // 루트 반환
        return node;
    parents[node] = collapsingFind(parents[node]); // 자손 노드들을 루트 노드에 달기
    return parents[node];
}

const unionRoots = (node1, node2) => {
    node1 = collapsingFind(node1);
    node2 = collapsingFind(node2);

    if(node1 !== node2) { // 두 루트가 다르다면
        if(knows[node1]) // 지식 전파
            knows[node2] = true;
        else if(knows[node2])
            knows[node1] = true;
        parents[node1] = node2; // 유니언
    }
}

const parties = Array.from({ length: m }, // 파티 참석자 정보
    (_, i) => input[i + 2].split(" ").slice(1).map(Number)
);
for(const party of parties)
    for(let i = 0; i < party.length - 1; i++)
        unionRoots(party[i], party[i + 1]); //파티 참석자 유니언 및 지식 전파

let possibleLieCount = 0;
for(const party of parties) {
    let canLie = true;
    for(const visitor of party) //파티마다
        if(knows[collapsingFind(visitor)]) { // 아는 사람이 있으면 거짓말을 못 함
            canLie = false;
            break;
        }
    if(canLie) possibleLieCount++;
}

console.log(possibleLieCount)