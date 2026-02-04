import sys
input = sys.stdin.readline

is_ascending = True
is_descending = True
notes = list(map(int, input().split()))
prev = notes[0]
for cur in notes[1:]:
    if prev >= cur: is_ascending = False
    if prev <= cur: is_descending = False
    prev = cur
if(is_ascending): print("ascending")
elif(is_descending): print("descending")
else: print("mixed")