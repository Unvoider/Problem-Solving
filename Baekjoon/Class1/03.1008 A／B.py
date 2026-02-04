import sys
input = sys.stdin.readline

a, b = map(int, input().split())
#a, b = (int(x) for x in input().split())
print(a / b)
#print(f"{a / b:.10f}")
#print("{0:.10f}".format(a / b))
#print("%.10f" % (a / b))