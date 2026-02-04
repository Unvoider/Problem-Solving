import sys
input = sys.stdin.readline

a = int(input())
b = int(input())
c = int(input())
product = a * b * c
count = [0] * 10
while product != 0:
    remainder = product % 10
    count[remainder] += 1
    product //= 10
print("\n".join(map(str, count)))

'''
a = int(input())
b = int(input())
c = int(input())
product = str(a * b * c)
for i in range(10):
    print(product.count(str(i)))
'''