import sys
input = sys.stdin.readline
write = sys.stdout.write

class BitmaskSet: #int 비트마스트 세트
    def __init__(self):
        self._set = 0
    def add(self, data):
        self._set |= 1 << (data - 1)
    def remove(self, data):
        self._set &= ~(1 << (data - 1))
    def check(self, data):
        return (self._set & (1 << (data - 1))) != 0
    def toggle(self, data):
        self._set ^= 1 << (data - 1)
    def all(self):
        self._set = (1 << 21) - 1
    def empty(self):
        self._set = 0

def main():
    m = int(input())
    s = BitmaskSet()
    out = []

    for _ in range(m):
        line = input().split()
        command = line[0]
        match(command):
            case "add":
                s.add(int(line[1]))
            case "remove":
                s.remove(int(line[1]))
            case "check":
                write(f"{"1" if s.check(int(line[1])) else "0"}\n")
            case "toggle":
                s.toggle(int(line[1]))
            case "all":
                s.all()
            case "empty":
                s.empty()

main()