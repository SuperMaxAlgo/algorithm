import copy
import sys

def clockwise(matrix):

    matrix_copy = copy.deepcopy(matrix)

    for i in range(N):
        for j in range(N):
            if i == j:
                matrix[i][mid] = matrix_copy[i][j]
            elif j == mid:
                matrix[i][N - 1 - i] = matrix_copy[i][j]
            elif i + j == N - 1:
                matrix[mid][j] = matrix_copy[i][j]
            elif i == mid:
                matrix[j][j] = matrix_copy[i][j]

    return matrix

T = int(sys.stdin.readline().rstrip())


for i in range(T):

    string = sys.stdin.readline().rstrip()

    N = int(string.split(' ')[0])

    D = int(string.split(' ')[1])

    mid = N // 2

    matrix = []

    for j in range(N):
        
        string = sys.stdin.readline().rstrip()

        matrix.append(string.split(' '))

    if D < 0:
        D += 360

    for i in range(D // 45):
        matrix = clockwise(matrix)

    for i in range(N):
        output = ''
        for j in range(N):
            output = output + ' ' + str(matrix[i][j])
        output = output[1:]
        print(output)