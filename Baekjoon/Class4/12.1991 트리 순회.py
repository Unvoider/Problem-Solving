import sys
input = sys.stdin.readline

EMPTY_NODE = "."

tree = {}
preorder_out = []
inorder_out = []
postorder_out = []

def get_order(node):
    if node == EMPTY_NODE: return
    preorder_out.append(node)
    get_order(tree[node][0])
    inorder_out.append(node)
    get_order(tree[node][1])
    postorder_out.append(node)

def main():
    n = int(input())

    for _ in range(n): #이진 트리
        parent, left, right = input().rstrip().split()
        tree[parent] = (left, right)

    get_order("A") #탐색
    print("\n".join(("".join(preorder_out), "".join(inorder_out), "".join(postorder_out))))

main()