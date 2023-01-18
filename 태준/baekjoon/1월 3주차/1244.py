import sys

N = int(sys.stdin.readline().rstrip())

switch = sys.stdin.readline().rstrip().split(' ')
switch = [int(i) for i in switch]

S = int(sys.stdin.readline().rstrip())

for i in range(S):
    change = sys.stdin.readline().rstrip().split(' ')
    sex = int(change[0])
    num = int(change[1])

    if sex == 1:

        n = 1
        while num * n <= N:
            switch[num * n - 1] = 1 - switch[num * n - 1]
            n += 1
        
    elif sex == 2:

        n = 1

        index = num - 1

        switch[index] = 1 - switch[index]

        while index - n >= 0 and index + n < N:
            if switch[index - n] == switch[index + n]:
                switch[index - n] = 1 - switch[index - n]
                switch[index + n] = 1 - switch[index + n]
                n += 1
            else:
                n -= 1
                break

output = ''
n = 1
for i in switch:
    if n <= 20:
        output = output + ' ' + str(i)
    else:
        output = output + '|' + str(i)
    n += 1

outputs = output[1:].split('|')

for i in outputs:
    print(i)