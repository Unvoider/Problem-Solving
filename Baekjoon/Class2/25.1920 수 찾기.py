import bisect
import sys
input = sys.stdin.readline
write = sys.stdout.write

def bin_search(li, num):
    left_insert = bisect.bisect_left(li, num)
    if left_insert < len(li) and li[left_insert] == num:
        return True
    return False

def main():
    _ = input()
    n_list = sorted(map(int, input().split())) #정렬
    _ = input()
    m_list = list(map(int, input().split()))

    for m_num in m_list:
        #이진 탐색 O(logn)
        if bin_search(n_list, m_num):
            write("1\n")
        else:
            write("0\n")

main()

''' 이진 탐색 구현
import sys
input = sys.stdin.readline
write = sys.stdout.write

def bin_search(li, num):
    left = 0
    right = len(li) - 1
    while left <= right:
        middle = (left + right) // 2
        if li[middle] == num:
            return middle
        elif li[middle] < num:
            left = middle + 1
        else:
            right = middle - 1
    return -1

def main():
    _ = input()
    n_list = sorted(map(int, input().split())) #정렬
    _ = input()
    m_list = list(map(int, input().split()))

    for m_num in m_list:
        #이진 탐색 O(logn)
        if bin_search(n_list, m_num) > -1:
            write("1\n")
        else:
            write("0\n")

main()
'''

''' set 사용
import sys
input = sys.stdin.readline
write = sys.stdout.write

_ = input()
n_set = set(map(int, input().split()))
_ = input()
m_list = list(map(int, input().split()))

for m_num in m_list:
    #set는 해시 테이블을 사용하므로 in 연산에 대해 O(1)
    if m_num in n_set:
        write("1\n")
    else:
        write("0\n")
'''