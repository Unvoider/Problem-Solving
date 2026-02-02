import sys
input = sys.stdin.readline

'''
def is_palindrome(string):
    length = len(string)
    for i in range(length // 2): #절반까지 비교
        if string[i] != string[length - 1 - i]:
            return False
    return True
'''

def main():
    while True:
        string = input().strip()
        if string == "0":
            break
        #if(is_palindrome(string)):
        if(string == string[::-1]):
            print("yes")
        else:
            print("no")

main()