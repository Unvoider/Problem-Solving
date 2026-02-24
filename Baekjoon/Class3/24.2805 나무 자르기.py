from collections import Counter
import sys
input = sys.stdin.readline

def is_length_enough(cutter_height, required, trees):
    length = 0
    for tree, count in trees:
        if tree > cutter_height:
            length += (tree - cutter_height) * count
            if length >= required: #충분한 길이
                return True
    return False #충분하지 않음

def max_cutter_height(required, trees):
    answer = 0
    left = 0
    right = max(tree for tree, _ in trees)
    while left <= right:
        middle = (left + right) // 2
        if is_length_enough(middle, required, trees): #더 높게 자를 수도 있음
            left = middle + 1
            answer = middle
        else: #더 낮게 잘라야 함
            right = middle - 1
    return answer

def main():
    _, m = map(int, input().split())
    trees = list(Counter(map(int, input().split())).items())
    print(max_cutter_height(m, trees))

main()