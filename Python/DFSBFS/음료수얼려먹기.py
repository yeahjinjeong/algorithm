import time
n, m = map(int, input().split())
board = [[int(x) for x in input()] for _ in range(n)]

start_time = time.time()

def dfs(board, i, j):
    if 0 <= i < n and 0 <= j < m and board[i][j] == 0:
        board[i][j] = -1
        dfs(board, i - 1, j)
        dfs(board, i, j - 1)
        dfs(board, i + 1, j)
        dfs(board, i, j + 1)
        return True
    else: return False

result = 0

for i in range(n):
    for j in range(m):
        if board[i][j] == 0 and dfs(board, i, j):
            result += 1

print(result)

end_time = time.time()
execute_time = end_time - start_time
print("time: ", round(execute_time, 9))

# 'if board[i][j] == 0 and dfs(board, i, j):' case
# time:  9.870529174804688e-05 => 0.000099182

# 'if dfs(board, i, j):' case
# time:  0.0001227855682373047 => 0.000128269

"""
4 5
00110
00011
11111
00000

15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111
"""
