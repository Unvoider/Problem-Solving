import sys
input = sys.stdin.readline

class Pokedex:
    def __init__(self):
        self._size = 0
        self._index_to_name = ["Dummy"] #0번 인덱스 더미 데이터
        self._name_to_index = {}
    def add(self, name):
        self._size += 1
        self._index_to_name.append(name)
        self._name_to_index[name] = self._size
    def get_name(self, index):
        return self._index_to_name[index]
    def get_index(self, name):
        return self._name_to_index[name]

def main():
    pokedex = Pokedex()
    n, m = map(int, input().split())
    out = []

    for _ in range(n): #이름 등록
        pokedex.add(input().rstrip())

    for _ in range(m): #검색
        target = input().rstrip()
        if(target[0].isdigit()): #인덱스 검색
            out.append(pokedex.get_name(int(target)))
        else: #이름 검색
            out.append(str(pokedex.get_index(target)))

    print("\n".join(out))

main()