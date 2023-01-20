import sys

def zoac(string, index):
    minindex = 0

    if string == '':
        return []

    if len(string) == 1:
        return [[string, index]]

    for i in range(len(string)):
        if string[i] == min(string):
            minindex = i
            break


    return zoac(string[:i], index + len(string[(i+1):]) + 1) + [[string[i], index]] + zoac(string[(i+1):], index + 1)

string = sys.stdin.readline().rstrip()

output = zoac(string, 0)

for i in range(len(output)):
    for j in range(len(output)):
        if 0 <= output[j][1] <= i:
            print(output[j][0], end='')
    print()