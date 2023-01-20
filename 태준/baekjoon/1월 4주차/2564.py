import sys

block = sys.stdin.readline().rstrip().split(' ')

W = int(block[0])
H = int(block[1])

N = int(sys.stdin.readline().rstrip())

stores = []

for i in range(N + 1):
    store = sys.stdin.readline().rstrip().split(' ')
    where = int(store[0])
    move = int(store[1])

    if where == 1:
        stores.append(move)
    elif where == 4:
        stores.append(W + move)
    elif where == 2:
        stores.append(W + H + (W - move))
    elif where == 3:
        stores.append(W + H + W + (H - move))

donggeun = stores.pop()

output = 0

for i in stores:
    if donggeun > i:
        dist = donggeun - i
    else:
        dist = i - donggeun

    if W + H < dist:
        dist = W*2 + H*2 - dist

    output += dist

print(output)