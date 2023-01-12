import sys

string = sys.stdin.readline().rstrip() + ' ' + sys.stdin.readline().rstrip() + ' ' + sys.stdin.readline().rstrip() + ' ' + sys.stdin.readline().rstrip() + ' ' + sys.stdin.readline().rstrip()
num = sys.stdin.readline().rstrip() + ' ' + sys.stdin.readline().rstrip() + ' ' + sys.stdin.readline().rstrip() + ' ' + sys.stdin.readline().rstrip() + ' ' + sys.stdin.readline().rstrip()

bingopan = string.split(' ')
numbers = num.split(' ')

bingonum = 0

count = 1

for i in numbers:
    jcount = 0
    for j in bingopan:
        if i == j:
            bingopan[jcount] = 0
        jcount += 1
    if count > 11:
        if int(bingopan[0]) + int(bingopan[1]) + int(bingopan[2]) + int(bingopan[3]) + int(bingopan[4]) == 0:
            bingonum += 1
        if int(bingopan[5]) + int(bingopan[6]) + int(bingopan[7]) + int(bingopan[8]) + int(bingopan[9]) == 0:
            bingonum += 1
        if int(bingopan[10]) + int(bingopan[11]) + int(bingopan[12]) + int(bingopan[13]) + int(bingopan[14]) == 0:
            bingonum += 1
        if int(bingopan[15]) + int(bingopan[16]) + int(bingopan[17]) + int(bingopan[18]) + int(bingopan[19]) == 0:
            bingonum += 1
        if int(bingopan[20]) + int(bingopan[21]) + int(bingopan[22]) + int(bingopan[23]) + int(bingopan[24]) == 0:
            bingonum += 1
        if int(bingopan[0]) + int(bingopan[5]) + int(bingopan[10]) + int(bingopan[15]) + int(bingopan[20]) == 0:
            bingonum += 1
        if int(bingopan[1]) + int(bingopan[6]) + int(bingopan[11]) + int(bingopan[16]) + int(bingopan[21]) == 0:
            bingonum += 1
        if int(bingopan[2]) + int(bingopan[7]) + int(bingopan[12]) + int(bingopan[17]) + int(bingopan[22]) == 0:
            bingonum += 1
        if int(bingopan[3]) + int(bingopan[8]) + int(bingopan[13]) + int(bingopan[18]) + int(bingopan[23]) == 0:
            bingonum += 1
        if int(bingopan[4]) + int(bingopan[9]) + int(bingopan[14]) + int(bingopan[19]) + int(bingopan[24]) == 0:
            bingonum += 1
        if int(bingopan[0]) + int(bingopan[6]) + int(bingopan[12]) + int(bingopan[18]) + int(bingopan[24]) == 0:
            bingonum += 1
        if int(bingopan[4]) + int(bingopan[8]) + int(bingopan[12]) + int(bingopan[16]) + int(bingopan[20]) == 0:
            bingonum += 1
        if bingonum >= 3:
            print(count)
            break
    bingonum = 0
    count += 1